package com.example.els.adapter.home;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.els.R;
import com.example.els.models.Api.ListeningQuestion;
import com.example.els.models.Grammar;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

public class GrammarAdapter extends RecyclerView.Adapter<GrammarAdapter.ViewHolder> {
    private List<Grammar> grammar = new ArrayList<>();
    private final OnLessonItemListener onLessonItemListener;

    public GrammarAdapter(List<Grammar> grammar,  OnLessonItemListener onLessonItemListener) {
        this.grammar = grammar;
        this.onLessonItemListener = onLessonItemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grammer,parent,false);
        return new ViewHolder(view, onLessonItemListener);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Grammar grammarName = grammar.get(position);
        int number = position +1;
        holder.textView.setText(String.valueOf(number));
        holder.textViewName.setText(grammarName.getName());
    }

    @Override
    public int getItemCount() {
        return grammar.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView textView;
        private final TextView textViewName;
        private final OnLessonItemListener onLessonItemListener;

        public ViewHolder(@NonNull View itemView, OnLessonItemListener onLessonItemListener) {
            super(itemView);
            textView = itemView.findViewById(R.id.grammar_number);
            textViewName = itemView.findViewById(R.id.grammar_name);
            this.onLessonItemListener = onLessonItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onLessonItemListener.onLessonClick(view , getAdapterPosition());
        }
    }

    public interface OnLessonItemListener {
        void onLessonClick(View view, int position);
    }
}
