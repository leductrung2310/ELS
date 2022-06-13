package com.example.els.adapter.home;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.els.R;
import com.example.els.component.GeneralInterface;
import com.example.els.models.Api.Listening;
import com.example.els.models.Api.ListeningFirebase;
import com.example.els.models.Api.ListeningQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DoneListeningAdapter extends RecyclerView.Adapter<DoneListeningAdapter.ViewHolder> {
    private List<ListeningQuestion> doneListeningQuestions = new ArrayList<>();
    private ListeningFirebase listeningFirebase;

    public DoneListeningAdapter(List<ListeningQuestion> doneListeningQuestions, ListeningFirebase listeningFirebase) {
        this.doneListeningQuestions = doneListeningQuestions;
        this.listeningFirebase = listeningFirebase;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_done_listening_lesson,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListeningQuestion listeningQuestion = doneListeningQuestions.get(position);
        String yourAnswer = listeningFirebase.getAnswer().get(position);
        String[] parts = listeningQuestion.getContent().split("___");
        String part1 = parts[0];
        String part2 = parts[1];
        String changeColorYour;
        if (listeningQuestion.getAnswer().equals(yourAnswer)) {
            changeColorYour = getColoredSpanned(yourAnswer, "#23c552");
        } else {
            changeColorYour = getColoredSpanned(yourAnswer, "#f84f31");
        }
        holder.textView1.setText(Html.fromHtml(part1 + listeningQuestion.getAnswer() + " (" + changeColorYour +")" + part2 ));
    }

    @Override
    public int getItemCount() {
        return doneListeningQuestions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.item_done_listening_lesson_1);
        }
    }

    private String getColoredSpanned(String text, String color) {
        String input = "<font color=" + color + ">" + text + "</font>";
        return input;
    }
}
