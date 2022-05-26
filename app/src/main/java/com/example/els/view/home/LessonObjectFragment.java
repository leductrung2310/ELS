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

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.els.R;
import com.example.els.adapter.LessonAdapter;
import com.example.els.adapter.home.ListeningAdapter;
import com.example.els.component.GeneralInterface;
import com.example.els.databinding.FragmentLessonObjectBinding;
import com.example.els.models.Api.Listening;
import com.example.els.models.Lesson;
import com.example.els.viewmodel.home.HomeViewModel;
import com.example.els.viewmodel.home.ListeningViewModel;
import com.example.els.viewmodel.home.ReadingViewModel;
import com.example.els.viewmodel.home.SpeakingViewModel;
import com.example.els.viewmodel.home.WritingViewModel;

import java.util.ArrayList;

// Instances of this class are fragments representing a single
// object in our collection.
public class LessonObjectFragment extends Fragment implements GeneralInterface.OnLessonItemListener {
    public static final String POSITION = "object";
    private FragmentLessonObjectBinding binding;
    private ListeningViewModel listeningViewModel;
    private ReadingViewModel readingViewModel;
    private SpeakingViewModel speakingViewModel;
    private WritingViewModel writingViewModel;

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
        HomeViewModel homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        listeningViewModel = new ViewModelProvider(requireActivity()).get(ListeningViewModel.class);
        readingViewModel = new ViewModelProvider(requireActivity()).get(ReadingViewModel.class);
        speakingViewModel = new ViewModelProvider(requireActivity()).get(SpeakingViewModel.class);
        writingViewModel = new ViewModelProvider(requireActivity()).get(WritingViewModel.class);

        //homeViewModel.getSkillKey().observe(getViewLifecycleOwner(), this::setUpLessonRecyclerView);
        recyclerView = binding.lessonRecyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        listeningViewModel.getDateListeningResponseLiveData();

        listenings = new ArrayList<>();
        listeningAdapter = new ListeningAdapter(getContext(), listenings, LessonObjectFragment.this);

        recyclerView.setAdapter(listeningAdapter);

        getListening();
    }

    private ArrayList<Listening> listenings;
    private ListeningAdapter listeningAdapter;
    private RecyclerView recyclerView;

    @SuppressLint("NotifyDataSetChanged")
    private void getListening() {
        listeningViewModel.getListeningResponseLiveData().observe(getViewLifecycleOwner(), data -> {
            if (data != null) {
                this.listenings.addAll(data);
                listeningAdapter.notifyDataSetChanged();
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
                    ArrayList<Listening> listenings = new ArrayList<>();
                    listeningViewModel.getListeningResponseLiveData().observe(getViewLifecycleOwner(), listenings1 ->{
                        if (listenings1 != null) {

                        }
                    } );
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
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        Navigation.findNavController(view).navigate(R.id.action_skillsFragment_to_lessonDetailFragment, bundle);
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}