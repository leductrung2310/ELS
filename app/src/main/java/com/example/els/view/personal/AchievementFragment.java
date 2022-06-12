package com.example.els.view.personal;

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

import com.example.els.R;
import com.example.els.adapter.AchievementAdapter;
import com.example.els.databinding.FragmentAchievementBinding;
import com.example.els.models.Achievement;
import com.example.els.models.Api.Listening;
import com.example.els.models.Api.ListeningFirebase;
import com.example.els.models.Api.ReadingFirebase;
import com.example.els.models.Api.ReadingLesson;
import com.example.els.viewmodel.home.ListeningViewModel;
import com.example.els.viewmodel.home.ReadingViewModel;

import java.util.ArrayList;
import java.util.Objects;

public class AchievementFragment extends Fragment {
    private FragmentAchievementBinding binding;
    private ListeningViewModel listeningViewModel;
    private ReadingViewModel readingViewModel;
    private  ArrayList<Achievement> courseModelArrayList;
    int score = 0;
    int duration = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAchievementBinding.inflate(getLayoutInflater());

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listeningViewModel = new ViewModelProvider(requireActivity()).get(ListeningViewModel.class);
        readingViewModel = new ViewModelProvider(requireActivity()).get(ReadingViewModel.class);
//        courseModelArrayList.add(new Achievement(R.drawable.gamipress_icon_add, ""));
//        courseModelArrayList.add(R.drawable.gamipress_icon_comment);
//        courseModelArrayList.add(R.drawable.gamipress_icon_heart);
//        courseModelArrayList.add(R.drawable.gamipress_icon_minus);
//        courseModelArrayList.add(R.drawable.gamipress_icon_pencil);
//        courseModelArrayList.add(R.drawable.gamipress_icon_quest);
//        courseModelArrayList.add(R.drawable.gamipress_icon_search);
//        courseModelArrayList.add(R.drawable.gamipress_icon_star);

        courseModelArrayList = new ArrayList<Achievement>();
        Achievement achievement_one = new Achievement(R.drawable.gamipress_icon_add, "First listening lesson");
        Achievement achievement_two = new Achievement(R.drawable.gamipress_icon_comment, "First reading lesson");
        Achievement achievement_three = new Achievement(R.drawable.gamipress_icon_heart, "Ten points");
        Achievement achievement_four = new Achievement(R.drawable.gamipress_icon_minus, "One hundreds points");
        Achievement achievement_five = new Achievement(R.drawable.gamipress_icon_pencil, "Ten lessons");
        Achievement achievement_six = new Achievement(R.drawable.gamipress_icon_quest, "All lessons");
        Achievement achievement_seven = new Achievement(R.drawable.gamipress_icon_search, "Fifty minutes learning");
        Achievement achievement_eight = new Achievement(R.drawable.gamipress_icon_star, "One hundreds minutes learning");

        listeningViewModel.getDoneListening().observe(getViewLifecycleOwner(), new Observer<ArrayList<Listening>>() {
            @Override
            public void onChanged(ArrayList<Listening> listenings) {
                if (listenings.size() > 0) {
                    courseModelArrayList.add(achievement_one);
                    setAchievement();
                }
            }
        });

        readingViewModel.getDoneReadingLesson().observe(getViewLifecycleOwner(), new Observer<ArrayList<ReadingLesson>>() {
            @Override
            public void onChanged(ArrayList<ReadingLesson> readingLessons) {
                if (readingLessons.size() > 0) {
                    courseModelArrayList.add(achievement_two);
                    setAchievement();
                }
            }
        });


        listeningViewModel.getDoneListeningFirebase().observe(getViewLifecycleOwner(), new Observer<ArrayList<ListeningFirebase>>() {
            @Override
            public void onChanged(ArrayList<ListeningFirebase> listeningFirebases) {
                for (ListeningFirebase _listeningFirebases: listeningFirebases
                ) {
                    score += Integer.parseInt(_listeningFirebases.getScore());
                }
            }
        });

        readingViewModel.getDoneReadingLessonFromFirebase().observe(getViewLifecycleOwner(), new Observer<ArrayList<ReadingFirebase>>() {
            @Override
            public void onChanged(ArrayList<ReadingFirebase> readingFirebases) {
                for (ReadingFirebase _readingFirebase: readingFirebases
                ) {
                    score += Integer.parseInt(_readingFirebase.getScore());
                }
            }
        });

        if (score >= 10) {
            courseModelArrayList.add(achievement_three);
            setAchievement();
        }

        if (score >= 100) {
            courseModelArrayList.add(achievement_four);
            setAchievement();
        }

        listeningViewModel.getDoneListening().observe(getViewLifecycleOwner(), new Observer<ArrayList<Listening>>() {
            @Override
            public void onChanged(ArrayList<Listening> listenings) {
                for (Listening _listeningFirebases: listenings
                ) {
                    duration += _listeningFirebases.getDuration();
                }
            }
        });

        readingViewModel.getDoneReadingLesson().observe(getViewLifecycleOwner(), new Observer<ArrayList<ReadingLesson>>() {
            @Override
            public void onChanged(ArrayList<ReadingLesson> readingLessons) {
                for (ReadingLesson _listeningFirebases: readingLessons
                ) {
                    duration += _listeningFirebases.getDuration();
                }
            }
        });

        if(duration >=50) {
            courseModelArrayList.add(achievement_seven);
            setAchievement();
        }
        if(duration >=100) {
            courseModelArrayList.add(achievement_eight);
            setAchievement();
        }

        listeningViewModel.getDoneListening().observe(getViewLifecycleOwner(), new Observer<ArrayList<Listening>>() {
            @Override
            public void onChanged(ArrayList<Listening> listenings) {
                if (listenings.size() == Objects.requireNonNull(listeningViewModel.getListeningLiveData().getValue()).size()) {
                    courseModelArrayList.add(achievement_five);
                    setAchievement();
                }
            }
        });

        readingViewModel.getDoneReadingLesson().observe(getViewLifecycleOwner(), new Observer<ArrayList<ReadingLesson>>() {
            @Override
            public void onChanged(ArrayList<ReadingLesson> readingLessons) {
                if (readingLessons.size() == Objects.requireNonNull(readingViewModel.getReadingLessonLiveData().getValue()).size()) {
                    courseModelArrayList.add(achievement_six);
                    setAchievement();
                }
            }
        });

        AchievementAdapter achievementAdapter = new AchievementAdapter(requireContext(),0,courseModelArrayList);

        binding.idGVcourses.setAdapter(achievementAdapter);
        Log.d("achievement", String.valueOf(courseModelArrayList.size()));



        binding.personalAchievementBack.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.action_achievementFragment_to_personalFragment));
    }

    @SuppressLint("SetTextI18n")
    public void setAchievement() {
        binding.achievement.setText(String.valueOf(courseModelArrayList.size()) + " out of 8 ");

        double per = (double) courseModelArrayList.size() / 8;
        int convertPer = (int) (per * 100);
        binding.progressCircular.setProgress(convertPer);
    }
}