package com.example.els.view.home;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.els.R;
import com.example.els.databinding.FragmentHomeBinding;
import com.example.els.viewmodel.home.HomeViewModel;
import com.example.els.viewmodel.home.ListeningViewModel;
import com.example.els.viewmodel.home.ReadingViewModel;
import com.example.els.viewmodel.home.SpeakingViewModel;
import com.example.els.viewmodel.home.WritingViewModel;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Objects;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;
    private ListeningViewModel listeningViewModel;
    private ReadingViewModel readingViewModel;
    private SpeakingViewModel speakingViewModel;
    private WritingViewModel writingViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Initialize view model
        homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        listeningViewModel = new ViewModelProvider(requireActivity()).get(ListeningViewModel.class);
        readingViewModel = new ViewModelProvider(requireActivity()).get(ReadingViewModel.class);
        speakingViewModel = new ViewModelProvider(requireActivity()).get(SpeakingViewModel.class);
        writingViewModel = new ViewModelProvider(requireActivity()).get(WritingViewModel.class);

        // Setup courses
        setUpCourses();

        // On Card click listener
        binding.listeningCardView.setOnClickListener(view1 -> moveToSkillLearningTab("listening", view1));
        binding.readingCardView.setOnClickListener(view12 -> moveToSkillLearningTab("reading", view12));
        binding.speakingCardView.setOnClickListener(view13 -> moveToSkillLearningTab("speaking", view13));
        binding.writingCardView.setOnClickListener(view14 -> moveToSkillLearningTab("writing", view14));

        // On notification button click
        binding.notificationBtn.setOnClickListener(this::moveToNotification);

        //get user data
        homeViewModel.getAccountInfo();
    }

    private void setUpCourses() {
        binding.listeningLessonsTv.setText(getResources().getString(R.string.totalLesson, listeningViewModel.getTotalLessons().getValue()));
        binding.readingLessonsTv.setText(getResources().getString(R.string.totalLesson, readingViewModel.getTotalLessons().getValue()));
        binding.speakingLessonsTv.setText(getResources().getString(R.string.totalLesson, speakingViewModel.getTotalLessons().getValue()));
        binding.writingLessonsTv.setText(getResources().getString(R.string.totalLesson, writingViewModel.getTotalLessons().getValue()));

        if (Objects.requireNonNull(listeningViewModel.getUndoneListeningLessons().getValue()).isEmpty())
            binding.listeningCompleteIc.setVisibility(View.VISIBLE);
        if (Objects.requireNonNull(readingViewModel.getUndoneReadingLessons().getValue()).isEmpty())
            binding.readingCompleteIc.setVisibility(View.VISIBLE);
        if (Objects.requireNonNull(speakingViewModel.getUndoneSpeakingLessons().getValue()).isEmpty())
            binding.speakingCompleteIc.setVisibility(View.VISIBLE);
        if (Objects.requireNonNull(writingViewModel.getUndoneWritingLessons().getValue()).isEmpty())
            binding.writingCompleteIc.setVisibility(View.VISIBLE);
    }

    private void moveToSkillLearningTab(String key, View view) {
        homeViewModel.setSkillKey(key);
        Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_skillsFragment);
    }

    private void moveToNotification(View view) {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(getActivity());
        materialAlertDialogBuilder.setTitle("Hello");
        materialAlertDialogBuilder.setNegativeButton(getString(R.string.personal), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        materialAlertDialogBuilder.setPositiveButton(getString(R.string.personal), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        materialAlertDialogBuilder.show();


        Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_notificationFragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}