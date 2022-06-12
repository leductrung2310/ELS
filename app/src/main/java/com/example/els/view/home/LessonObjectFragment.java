package com.example.els.view.home;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.els.R;
import com.example.els.adapter.LessonAdapter;
import com.example.els.adapter.home.ListeningAdapter;
import com.example.els.adapter.home.ReadingAdapter;
import com.example.els.component.GeneralInterface;
import com.example.els.databinding.FragmentLessonObjectBinding;
import com.example.els.models.Api.Listening;
import com.example.els.models.Api.ReadingLesson;
import com.example.els.models.Api.ReadingQuestion;
import com.example.els.models.Lesson;
import com.example.els.viewmodel.home.HomeViewModel;
import com.example.els.viewmodel.home.ListeningViewModel;
import com.example.els.viewmodel.home.ReadingViewModel;
import com.example.els.viewmodel.home.SpeakingViewModel;
import com.example.els.viewmodel.home.WritingViewModel;

import java.util.ArrayList;
import java.util.List;

// Instances of this class are fragments representing a single
// object in our collection.
public class LessonObjectFragment extends Fragment implements GeneralInterface.OnLessonItemListener {
    public static final String POSITION = "object";
    private FragmentLessonObjectBinding binding;
    private ListeningViewModel listeningViewModel;
    private ReadingViewModel readingViewModel;
    private SpeakingViewModel speakingViewModel;
    private WritingViewModel writingViewModel;
    private HomeViewModel homeViewModel;
    private ListeningAdapter listeningAdapter;
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
        speakingViewModel = new ViewModelProvider(requireActivity()).get(SpeakingViewModel.class);
        writingViewModel = new ViewModelProvider(requireActivity()).get(WritingViewModel.class);

        homeViewModel.getSkillKey().observe(getViewLifecycleOwner(), this::setUpSkill);
        recyclerView = binding.lessonRecyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

//        listeningViewModel.getDataListeningLesson();
//        setUpObserver();
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
            case "speaking": {
                break;
            }
            case "writing": {
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
//        final Observer<List<Listening>> listObserver = data -> {
//            if (data != null) {
//                listeningAdapter = new ListeningAdapter(getContext(), data, LessonObjectFragment.this);
//                recyclerView.setAdapter(listeningAdapter);
//                binding.gifEmpty.setVisibility(View.GONE);
//            } else {
//                binding.gifEmpty.setVisibility(View.GONE);
//                //binding.textState.setVisibility(View.VISIBLE);
//            }
//        };
//        listeningViewModel.getListeningLiveData().observe(getViewLifecycleOwner(), listObserver);

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
        binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listeningViewModel.getDataListeningLesson();
                readingViewModel.getAllReadingLesson();
                binding.swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    public void setUpLessonRecyclerView(String key) {
        RecyclerView recyclerView = binding.lessonRecyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        // Create observer which updates UI
        final Observer<ArrayList<Lesson>> listObserver = new Observer<ArrayList<Lesson>>() {
            @Override
            public void onChanged(ArrayList<Lesson> arrayList) {
                if (arrayList.isEmpty()) {
                    recyclerView.setVisibility(View.GONE);
                    assert LessonObjectFragment.this.getArguments() != null;
                    if (LessonObjectFragment.this.getArguments().getInt(POSITION) == 1) {
                        binding.gifEmpty.setVisibility(View.VISIBLE);
                    } else binding.gifSuccess.setVisibility(View.VISIBLE);
                } else {
                    LessonAdapter lessonAdapter = new LessonAdapter(arrayList, LessonObjectFragment.this);
                    recyclerView.setAdapter(lessonAdapter);
                }
            }
        };
        // Observe the LiveData, passing the LifecycleOwner and the observer.
        assert getArguments() != null;
        if (getArguments().getInt(POSITION) == 1) {
            switch (key) {
                case "listening": {
                    //listeningViewModel.getDoneListeningLessons().observe(getViewLifecycleOwner(), listObserver);


                    break;
                }
                case "reading": {
                    readingViewModel.getDoneReadingLessons().observe(getViewLifecycleOwner(), listObserver);
                    break;
                }
                case "speaking": {
                    speakingViewModel.getDoneSpeakingLessons().observe(getViewLifecycleOwner(), listObserver);
                    break;
                }
                case "writing": {
                    writingViewModel.getDoneWritingLessons().observe(getViewLifecycleOwner(), listObserver);
                    break;
                }
            }
        } else {
            switch (key) {
                case "listening": {
                    listeningViewModel.getUndoneListeningLessons().observe(getViewLifecycleOwner(), listObserver);
                    break;
                }
                case "reading": {
                    readingViewModel.getUndoneReadingLessons().observe(getViewLifecycleOwner(), listObserver);
                    break;
                }
                case "speaking": {
                    speakingViewModel.getUndoneSpeakingLessons().observe(getViewLifecycleOwner(), listObserver);
                    break;
                }
                case "writing": {
                    writingViewModel.getUndoneWritingLessons().observe(getViewLifecycleOwner(), listObserver);
                    break;
                }
            }
        }
    }

    @Override
    public void onLessonClick(View view, int position) {
        homeViewModel.getSkillKey().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                switch (s) {
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
                            readingViewModel.getDoneReadingLesson().observe(getViewLifecycleOwner(), new Observer<ArrayList<ReadingLesson>>() {
                                @Override
                                public void onChanged(ArrayList<ReadingLesson> readingLessons) {
                                    readingViewModel.getReadingQuestionByReadingLesson(readingLessons.get(readingViewModel.getPosition()).getUuid());
                                    readingViewModel.setReadingLesson(readingLessons.get(readingViewModel.getPosition()));
                                }
                            });
                            readingViewModel.getReadingQuestionsLiveDate().observe(getViewLifecycleOwner(), new Observer<List<ReadingQuestion>>() {
                                @Override
                                public void onChanged(List<ReadingQuestion> readingQuestions) {
                                    Navigation.findNavController(view).navigate(R.id.action_skillsFragment_to_doneReadingLessonragment);
                                }
                            });
                        } else {
                            Log.d("listening", "click item undone");
                            readingViewModel.getUndoneReadingLesson().observe(getViewLifecycleOwner(), new Observer<ArrayList<ReadingLesson>>() {
                                @Override
                                public void onChanged(ArrayList<ReadingLesson> readingLessons) {
                                    readingViewModel.getReadingQuestionByReadingLesson(readingLessons.get(readingViewModel.getPosition()).getUuid());
                                    readingViewModel.setReadingLesson(readingLessons.get(readingViewModel.getPosition()));
                                }
                            });
                            readingViewModel.getReadingQuestionsLiveDate().observe(getViewLifecycleOwner(), new Observer<List<ReadingQuestion>>() {
                                @Override
                                public void onChanged(List<ReadingQuestion> readingQuestions) {
                                    Navigation.findNavController(view).navigate(R.id.action_skillsFragment_to_readingQuestionFragment);
                                }
                            });
                        }
                        break;
                    }

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