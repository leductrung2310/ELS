package com.example.els.adapter.home;

import android.annotation.SuppressLint;
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
import com.example.els.models.Api.ListeningQuestion;

import java.util.ArrayList;
import java.util.List;

public class DoneListeningAdapter extends RecyclerView.Adapter<DoneListeningAdapter.ViewHolder> {
    private List<ListeningQuestion> doneListeningQuestions = new ArrayList<>();

    public DoneListeningAdapter(List<ListeningQuestion> doneListeningQuestions) {
        this.doneListeningQuestions = doneListeningQuestions;
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
        String[] parts = listeningQuestion.getContent().split("___");
        String part1 = parts[0];
        String part2 = parts[1];
        holder.textView.setText(part1 + listeningQuestion.getAnswer() + part2);
    }

    @Override
    public int getItemCount() {
        return doneListeningQuestions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_done_listening_lesson);
        }
    }
}
