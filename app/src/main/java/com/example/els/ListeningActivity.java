package com.example.els;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import com.example.els.adapter.LessonAdapter;
import com.example.els.databinding.ActivityListeningBinding;
import com.example.els.models.Lesson;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ListeningActivity extends AppCompatActivity {
    private ActivityListeningBinding binding;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListeningBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        addNewTestLessonItem();
        RecyclerView recyclerView = binding.lessonRecyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LessonAdapter lessonAdapter = new LessonAdapter(this, lessonsList);
        recyclerView.setAdapter(lessonAdapter);
    }
}