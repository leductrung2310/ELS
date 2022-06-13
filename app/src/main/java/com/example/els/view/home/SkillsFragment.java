package com.example.els.view.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import com.example.els.R;
import com.example.els.adapter.LessonCollectionAdapter;
import com.example.els.databinding.FragmentSkillsBinding;
import com.example.els.models.Api.Listening;
import com.example.els.models.Api.ReadingLesson;
import com.example.els.viewmodel.home.HomeViewModel;
import com.example.els.viewmodel.home.ListeningViewModel;
import com.example.els.viewmodel.home.ReadingViewModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

public class SkillsFragment extends Fragment {
    private FragmentSkillsBinding binding;
    private HomeViewModel homeViewModel;
    private ListeningViewModel listeningViewModel;
    private ReadingViewModel readingViewModel;

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

        binding.actionBtn.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.action_skillsFragment_to_instructionListeningFragment));
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
        switch (key) {
            case "listening": {
                listeningViewModel.getListeningLiveData().observe(getViewLifecycleOwner(), listenings -> {
                    int duration = 0;
                    for(Listening listening: listenings) {
                        duration += listening.getDuration();
                    }
                    binding.totalDuration.setText(getResources().getString(R.string.totalDuration, duration));
                    binding.totalLessons.setText(getResources().getString(R.string.totalLesson, listenings.size()));

                });
                listeningViewModel.getDoneListening().observe(getViewLifecycleOwner(), listenings -> {
                    double per = (double) listenings.size() / Objects.requireNonNull(listeningViewModel.getListeningLiveData().getValue()).size();
                    int convertPer = (int) (per * 100);
                    binding.percentage.setText(String.valueOf(convertPer));
                    binding.circleProgressIndicator.setProgress(convertPer);
                });

                break;
            }
            case "reading": {
                readingViewModel.getReadingLessonLiveData().observe(getViewLifecycleOwner(), readingLessons -> {
                    int duration = 0;
                    for(ReadingLesson readingLesson: readingLessons) {
                        duration += readingLesson.getDuration();
                    }
                    binding.totalDuration.setText(getResources().getString(R.string.totalDuration, duration));
                    binding.totalLessons.setText(getResources().getString(R.string.totalLesson, readingLessons.size()));
                });

                readingViewModel.getDoneReadingLesson().observe(getViewLifecycleOwner(), readingLessons -> {
                    double per = (double) readingLessons.size() / Objects.requireNonNull(readingViewModel.getReadingLessonLiveData().getValue()).size();
                    int convertPer = (int) (per * 100);
                    binding.percentage.setText(String.valueOf(convertPer));
                    binding.circleProgressIndicator.setProgress(convertPer);
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
            case "reading": {
                binding.skillName.setText(R.string.reading);
                binding.skillIcon.setImageResource(R.drawable.ic_notebook);
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