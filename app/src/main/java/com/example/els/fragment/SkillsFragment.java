package com.example.els.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.els.R;
import com.example.els.adapter.LessonAdapter;
import com.example.els.databinding.FragmentSkillsBinding;
import com.example.els.models.Lesson;

import java.util.ArrayList;

public class SkillsFragment extends Fragment {
    private FragmentSkillsBinding binding;

    ArrayList<Lesson> lessonsList = new ArrayList<>();
    private void addNewTestLessonItem() {
        Lesson lesson1 = new Lesson(1, "Family life", "12 min");
        Lesson lesson2 = new Lesson(2, "Children's life", "12 min");
        Lesson lesson3 = new Lesson(3, "Friends", "12 min");
        Lesson lesson4 = new Lesson(4, "Live in the wild", "12 min");
        Lesson lesson5 = new Lesson(5, "Movies you will love", "12 min");
        lessonsList.add(lesson1);
        lessonsList.add(lesson2);
        lessonsList.add(lesson3);
        lessonsList.add(lesson4);
        lessonsList.add(lesson5);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSkillsBinding.inflate(inflater, container, false);
        addNewTestLessonItem();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // Get argument from previous fragment
        String key = SkillsFragmentArgs.fromBundle(getArguments()).getSkillArg();
        assert key != null;
        setContentSkills(key);

        // Handle custom back button
        binding.backBtn.setOnClickListener(this::onBackButtonPressed);

        // Setup data lessons
        setUpLessonRecyclerView(key);
    }

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
        Navigation.findNavController(view).navigate(R.id.action_skillsFragment_to_homeFragment);
    }

    public void setUpLessonRecyclerView(String key) {
        RecyclerView recyclerView = binding.lessonRecyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        LessonAdapter lessonAdapter = new LessonAdapter(getContext(), lessonsList);
        recyclerView.setAdapter(lessonAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}