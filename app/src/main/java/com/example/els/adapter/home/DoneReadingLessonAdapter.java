package com.example.els.adapter.home;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.els.R;
import com.example.els.models.Api.ListeningQuestion;
import com.example.els.models.Api.ReadingAnswer;
import com.example.els.models.Api.ReadingLesson;
import com.example.els.models.Api.ReadingQuestion;

import java.util.ArrayList;
import java.util.List;

public class DoneReadingLessonAdapter extends RecyclerView.Adapter<DoneReadingLessonAdapter.ViewHolder> {
    private List<ReadingQuestion> readingQuestions = new ArrayList<>();
    private ArrayList<ReadingAnswer> readingAnswers = new ArrayList<>();

    public DoneReadingLessonAdapter(List<ReadingQuestion> readingQuestions, ArrayList<ReadingAnswer> readingAnswers) {
        Log.d("done reading adapter",  " " + readingQuestions.size() + readingAnswers.size());
        this.readingQuestions = readingQuestions;
        this.readingAnswers = readingAnswers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_done_listening_lesson,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return readingAnswers.size();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ReadingQuestion readingQuestion = readingQuestions.get(position);

        ReadingAnswer readingAnswer = readingAnswers.get(position);
        String[] parts = readingQuestion.getContent().split("___");
        String part1 = parts[0];
        String part2 = parts[1];


        String[] partsAnswer = readingAnswer.getAnswer().split(". ");
        String part1Answer = partsAnswer[0];
        String part2Answer = partsAnswer[1];
        holder.textView.setText(part1 + part2Answer + part2);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_done_listening_lesson_1);
        }
    }
}
