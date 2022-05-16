package com.example.els.view.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.els.R;
import com.example.els.adapter.LessonCollectionAdapter;
import com.example.els.databinding.FragmentSkillsBinding;
import com.example.els.viewmodel.home.HomeViewModel;
import com.example.els.viewmodel.home.ListeningViewModel;
import com.example.els.viewmodel.home.ReadingViewModel;
import com.example.els.viewmodel.home.SpeakingViewModel;
import com.example.els.viewmodel.home.WritingViewModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class SkillsFragment extends Fragment {
    private FragmentSkillsBinding binding;
    private HomeViewModel homeViewModel;
    private ListeningViewModel listeningViewModel;
    private ReadingViewModel readingViewModel;
    private SpeakingViewModel speakingViewModel;
    private WritingViewModel writingViewModel;

    // When requested, this adapter returns a DemoObjectFragment,
    // representing an object in the collection.
    LessonCollectionAdapter lessonCollectionAdapter;
    ViewPager2 viewPager2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSkillsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // Initialize view model
        homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        listeningViewModel = new ViewModelProvider(requireActivity()).get(ListeningViewModel.class);
        readingViewModel = new ViewModelProvider(requireActivity()).get(ReadingViewModel.class);
        speakingViewModel = new ViewModelProvider(requireActivity()).get(SpeakingViewModel.class);
        writingViewModel = new ViewModelProvider(requireActivity()).get(WritingViewModel.class);

        // Get argument from previous fragment
        homeViewModel.getSkillKey().observe(getViewLifecycleOwner(), key -> {
            setContentSkills(key);
            setupView(key);
        });

        // Handle custom back button
        binding.backBtn.setOnClickListener(this::onBackButtonPressed);

        // Setup view pager and adapter
        lessonCollectionAdapter = new LessonCollectionAdapter(this);
        viewPager2 = binding.lessonPager;
        viewPager2.setAdapter(lessonCollectionAdapter);

        // Setup tab layout
        setupTabLayout();
    }

    public void setupTabLayout() {
        TabLayout tabLayout = binding.tabLayout;
        // Use tab layout mediator to attach view pager with tab layout
        new TabLayoutMediator(
                tabLayout, viewPager2,
                (tab, position) -> {
                    // Set up tab title
                    if (position == 0) {
                        tab.setText(getResources().getText(R.string.undone));
                    } else {
                        tab.setText(getResources().getText(R.string.done));
                    }
                })
                .attach();
    }

    // Set up view whenever get inside the skills fragment
    public void setupView(String key) {
        TextView durationTextView = binding.totalDuration;
        TextView totalLessonTextView = binding.totalLessons;
        TextView percentTextView = binding.percentage;
        ProgressBar progressBar = binding.circleProgressIndicator;

        switch(key) {
            case "listening": {
                listeningViewModel.getTotalDuration().observe(getViewLifecycleOwner(), duration -> durationTextView.setText(getResources().getString(R.string.totalDuration, duration)));
                listeningViewModel.getTotalLessons().observe(getViewLifecycleOwner(), lessons -> totalLessonTextView.setText(getResources().getString(R.string.totalLesson, lessons)));
                listeningViewModel.getCompletePercentage().observe(getViewLifecycleOwner(), percentage -> {
                    percentTextView.setText(getResources().getString(R.string.percentage, percentage));
                    progressBar.setProgress(percentage);
                });
                break;
            }
            case "reading": {
                readingViewModel.getTotalDuration().observe(getViewLifecycleOwner(), duration -> durationTextView.setText(getResources().getString(R.string.totalDuration, duration)));
                readingViewModel.getTotalLessons().observe(getViewLifecycleOwner(), lessons -> totalLessonTextView.setText(getResources().getString(R.string.totalLesson, lessons)));
                readingViewModel.getCompletePercentage().observe(getViewLifecycleOwner(), percentage -> {
                    percentTextView.setText(getResources().getString(R.string.percentage, percentage));
                    progressBar.setProgress(percentage);
                });
                break;
            }
            case "speaking": {
                speakingViewModel.getTotalDuration().observe(getViewLifecycleOwner(), duration -> durationTextView.setText(getResources().getString(R.string.totalDuration, duration)));
                speakingViewModel.getTotalLessons().observe(getViewLifecycleOwner(), lessons -> totalLessonTextView.setText(getResources().getString(R.string.totalLesson, lessons)));
                speakingViewModel.getCompletePercentage().observe(getViewLifecycleOwner(), percentage -> {
                    percentTextView.setText(getResources().getString(R.string.percentage, percentage));
                    progressBar.setProgress(percentage);
                });
                break;
            }
            case "writing": {
                writingViewModel.getTotalDuration().observe(getViewLifecycleOwner(), duration -> durationTextView.setText(getResources().getString(R.string.totalDuration, duration)));
                writingViewModel.getTotalLessons().observe(getViewLifecycleOwner(), lessons -> totalLessonTextView.setText(getResources().getString(R.string.totalLesson, lessons)));
                writingViewModel.getCompletePercentage().observe(getViewLifecycleOwner(), percentage -> {
                    percentTextView.setText(getResources().getString(R.string.percentage, percentage));
                    progressBar.setProgress(percentage);
                });
                break;
            }
        }
    }

    // Setup appropriate content for each skill
    public void setContentSkills(String key) {
        switch (key) {
            case "listening": {
                binding.skillName.setText(R.string.listening);
                binding.skillIcon.setImageResource(R.drawable.ic_headphone);
                break;
            }
            case "writing": {
                binding.skillName.setText(R.string.writing);
                binding.skillIcon.setImageResource(R.drawable.ic_pen);
                break;
            }
            case "reading": {
                binding.skillName.setText(R.string.reading);
                binding.skillIcon.setImageResource(R.drawable.ic_notebook);
                break;
            }
            case "speaking": {
                binding.skillName.setText(R.string.speaking);
                binding.skillIcon.setImageResource(R.drawable.ic_speaker);
                break;
            }
        }
    }

    public void onBackButtonPressed(View view) {
        homeViewModel.setSkillKey("null");
        binding.circleProgressIndicator.setProgress(0);
        Navigation.findNavController(view).navigate(R.id.action_skillsFragment_to_homeFragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}