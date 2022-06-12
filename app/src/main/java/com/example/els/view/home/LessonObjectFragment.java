package com.example.els.view.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.els.R;
import com.example.els.adapter.home.ListeningAdapter;
import com.example.els.adapter.home.ReadingAdapter;
import com.example.els.component.GeneralInterface;
import com.example.els.databinding.FragmentLessonObjectBinding;
import com.example.els.models.Api.Listening;
import com.example.els.models.Api.ReadingLesson;
import com.example.els.viewmodel.home.HomeViewModel;
import com.example.els.viewmodel.home.ListeningViewModel;
import com.example.els.viewmodel.home.ReadingViewModel;

import java.util.List;

// Instances of this class are fragments representing a single
// object in our collection.
public class LessonObjectFragment extends Fragment implements GeneralInterface.OnLessonItemListener {
    public static final String POSITION = "object";
    private FragmentLessonObjectBinding binding;
    private ListeningViewModel listeningViewModel;
    private ReadingViewModel readingViewModel;
    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;

    private ListeningAdapter unDoneListeningAdapter;
    private ListeningAdapter doneListeningAdapter;

    private ReadingAdapter unDoneReadingAdapter;
    private ReadingAdapter doneReadingAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLessonObjectBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get the viewmodel
        homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        listeningViewModel = new ViewModelProvider(requireActivity()).get(ListeningViewModel.class);
        readingViewModel = new ViewModelProvider(requireActivity()).get(ReadingViewModel.class);

        homeViewModel.getSkillKey().observe(getViewLifecycleOwner(), this::setUpSkill);
        recyclerView = binding.lessonRecyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        setUpEvent();
    }

    private void setUpSkill(String key) {
        switch (key) {
            case "listening": {
                //listeningViewModel.getDoneListeningLessons().observe(getViewLifecycleOwner(), listObserver);
                listeningViewModel.getDataListeningLesson();
                setUpObserver();
                break;
            }
            case "reading": {
                readingViewModel.getAllReadingLesson();
                setUpObserverReadingLesson();
                break;
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private void setUpObserverReadingLesson() {


        final Observer<List<ReadingLesson>> unDoneLReadingLesson = data -> {
            Log.d("reading lesson", "ob unDone");
            if (data != null) {
                unDoneReadingAdapter = new ReadingAdapter(getContext(), data, LessonObjectFragment.this, 0);
                recyclerView.setAdapter(unDoneReadingAdapter);
                binding.gifEmpty.setVisibility(View.GONE);
            } else {
                binding.gifEmpty.setVisibility(View.GONE);
                binding.textState.setVisibility(View.VISIBLE);
            }
        };

        final Observer<List<ReadingLesson>> doneReadingLesson = data -> {
            Log.d("reading lesson", "ob done");
            if (data != null) {
                doneReadingAdapter = new ReadingAdapter(getContext(), data, LessonObjectFragment.this, 1);
                recyclerView.setAdapter(doneReadingAdapter);
                binding.gifEmpty.setVisibility(View.GONE);
            } else {
                binding.gifEmpty.setVisibility(View.GONE);
                binding.textState.setVisibility(View.VISIBLE);
            }
        };

        assert getArguments() != null;
        if (getArguments().getInt(POSITION) == 1) {
            Log.d("listening", "done");
            readingViewModel.getDoneReadingLesson().observe(getViewLifecycleOwner(), doneReadingLesson);
        } else {
            Log.d("listening", "undone");
            readingViewModel.getUndoneReadingLesson().observe(getViewLifecycleOwner(), unDoneLReadingLesson);
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private void setUpObserver() {
        final Observer<List<Listening>> unDoneListeningLesson = data -> {
            if (data != null) {
                unDoneListeningAdapter = new ListeningAdapter(getContext(), data, LessonObjectFragment.this, 0);
                recyclerView.setAdapter(unDoneListeningAdapter);
                binding.gifEmpty.setVisibility(View.GONE);
            } else {
                binding.gifEmpty.setVisibility(View.GONE);
                binding.textState.setVisibility(View.VISIBLE);
            }
        };

        final Observer<List<Listening>> doneListeningLesson = data -> {
            Log.d("listening", "ob done");
            if (data != null) {
                Log.d("listening", "ob done 1");
                doneListeningAdapter = new ListeningAdapter(getContext(), data, LessonObjectFragment.this, 1);
                recyclerView.setAdapter(doneListeningAdapter);
                binding.gifEmpty.setVisibility(View.GONE);
            } else {
                Log.d("listening", "ob done 2");
                binding.gifEmpty.setVisibility(View.GONE);
                binding.textState.setVisibility(View.VISIBLE);
            }
        };

        assert getArguments() != null;
        if (getArguments().getInt(POSITION) == 1) {
            Log.d("listening", "done");
            listeningViewModel.getDoneListening().observe(getViewLifecycleOwner(), doneListeningLesson);
        } else {
            Log.d("listening", "undone");
            listeningViewModel.getUnDoneListening().observe(getViewLifecycleOwner(), unDoneListeningLesson);
        }
    }

    public void setUpEvent() {
        binding.swipeRefreshLayout.setOnRefreshListener(() -> {
            listeningViewModel.getDataListeningLesson();
            readingViewModel.getAllReadingLesson();
            binding.swipeRefreshLayout.setRefreshing(false);
        });
    }

    @Override
    public void onLessonClick(View view, int position) {
        homeViewModel.getSkillKey().observe(getViewLifecycleOwner(), key -> {
            switch (key) {
                case "listening": {
                    assert getArguments() != null;
                    listeningViewModel.setPosition(position);
                    if (getArguments().getInt(POSITION) == 1) {
                        Log.d("listening", "done");
                        Navigation.findNavController(view).navigate(R.id.action_skillsFragment_to_doneListeningLessonFragment);
                    } else {
                        Log.d("listening", "undone");
                        Navigation.findNavController(view).navigate(R.id.action_skillsFragment_to_lessonDetailFragment);
                    }
                    break;
                }
                case "reading": {
                    assert getArguments() != null;
                    readingViewModel.setPosition(position);
                    if (getArguments().getInt(POSITION) == 1) {
                        Log.d("reading lesson", "click item done");
                        readingViewModel.getDoneReadingLesson().observe(getViewLifecycleOwner(), readingLessons -> {
                            readingViewModel.getReadingQuestionByReadingLesson(readingLessons.get(readingViewModel.getPosition()).getUuid());
                            readingViewModel.setReadingLesson(readingLessons.get(readingViewModel.getPosition()));
                        });
                        readingViewModel.getReadingQuestionsLiveDate().observe(getViewLifecycleOwner(), readingQuestions -> Navigation.findNavController(view).navigate(R.id.action_skillsFragment_to_doneReadingLessonragment));
                    } else {
                        Log.d("listening", "click item undone");
                        readingViewModel.getUndoneReadingLesson().observe(getViewLifecycleOwner(), readingLessons -> {
                            readingViewModel.getReadingQuestionByReadingLesson(readingLessons.get(readingViewModel.getPosition()).getUuid());
                            readingViewModel.setReadingLesson(readingLessons.get(readingViewModel.getPosition()));
                        });
                        readingViewModel.getReadingQuestionsLiveDate().observe(getViewLifecycleOwner(), readingQuestions -> Navigation.findNavController(view).navigate(R.id.action_skillsFragment_to_readingQuestionFragment));
                    }
                    break;
                }

            }
        });

    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}