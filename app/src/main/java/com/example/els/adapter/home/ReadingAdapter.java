package com.example.els.adapter.home;

import android.annotation.SuppressLint;
import android.content.Context;
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
import com.example.els.models.Api.ReadingLesson;

import java.util.ArrayList;
import java.util.List;

public class ReadingAdapter extends  RecyclerView.Adapter<ReadingAdapter.ViewHolder> {
    private final ArrayList<ReadingLesson> readingLessons = new ArrayList<>();
    private Context context;
    private final GeneralInterface.OnLessonItemListener mOnLessonItemListener;
    private int check;

    public ReadingAdapter(Context context, List<ReadingLesson> list, GeneralInterface.OnLessonItemListener onLessonItemListener, int check) {
        this.readingLessons.addAll(list);
        this.context = context;
        this.mOnLessonItemListener = onLessonItemListener;
        this.check = check;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.lesson_item,parent,false);
        return new ViewHolder(view, mOnLessonItemListener);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ReadingLesson readingLesson=  readingLessons.get(position);
        holder.numberLessonTV.setText(String.valueOf(position+1));
        holder.nameLessonTV.setText(readingLesson.getTitle());
        holder.durationTV.setText(readingLesson.getDuration() + " minutes");
        if (check == 0) {
            holder.stateImageView.setImageResource(R.drawable.undone_button_background);
        }
    }

    @Override
    public int getItemCount() {
        return readingLessons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView numberLessonTV;
        private final TextView nameLessonTV;
        private final TextView durationTV;
        private final ImageView stateImageView;
        private final ImageView stateIcon;
        private final GeneralInterface.OnLessonItemListener onLessonItemListener;

        public ViewHolder(@NonNull View itemView, GeneralInterface.OnLessonItemListener onLessonItemListener) {
            super(itemView);
            numberLessonTV = itemView.findViewById(R.id.lesson_number);
            nameLessonTV = itemView.findViewById(R.id.lesson_name);
            durationTV = itemView.findViewById(R.id.duration_tv);
            stateImageView = itemView.findViewById(R.id.state_img);
            stateIcon = itemView.findViewById(R.id.state_ic);
            this.onLessonItemListener = onLessonItemListener;

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            onLessonItemListener.onLessonClick(view, getAdapterPosition());
        }
    }
}
