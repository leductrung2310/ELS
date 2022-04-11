package com.example.els.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.els.R;
import com.example.els.models.Lesson;

import java.util.ArrayList;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.ViewHolder> {
    private ArrayList<Lesson> arrayListLesson;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView numberLessonTV;
        private final TextView nameLessonTV;
        private final TextView durationTV;
        private final ImageView stateImageView;
        private final ImageView stateIcon;

        public ViewHolder(View view) {
            super(view);

            numberLessonTV = (TextView) view.findViewById(R.id.lesson_number);
            nameLessonTV = (TextView) view.findViewById(R.id.lesson_name);
            durationTV = (TextView) view.findViewById(R.id.duration_tv);
            stateImageView = (ImageView) view.findViewById(R.id.state_img);
            stateIcon = (ImageView) view.findViewById(R.id.state_ic);
        }

        public TextView getNumberLessonTV() {
            return numberLessonTV;
        }

        public TextView getNameLessonTV() {
            return nameLessonTV;
        }

        public TextView getDurationTV() {
            return durationTV;
        }

        public ImageView getStateImageView() {
            return stateImageView;
        }

        public ImageView getStateIcon() {
            return stateIcon;
        }
    }

    public LessonAdapter(Context context, ArrayList<Lesson> arrayList) {
        arrayListLesson = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lesson_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lesson item = arrayListLesson.get(position);

        holder.getNumberLessonTV().setText(String.valueOf(item.getLessonNumber()));
        holder.getNameLessonTV().setText(item.getLessonName());
        holder.getDurationTV().setText(item.getDuration());
    }

    @Override
    public int getItemCount() {
        return arrayListLesson.size();
    }
}
