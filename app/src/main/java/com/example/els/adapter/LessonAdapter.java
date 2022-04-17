package com.example.els.adapter;

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
import com.example.els.models.Lesson;

import java.util.ArrayList;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.ViewHolder> {
    private final ArrayList<Lesson> arrayListLesson;
    private final GeneralInterface.OnLessonItemListener mOnLessonItemListener;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView numberLessonTV;
        private final TextView nameLessonTV;
        private final TextView durationTV;
        private final ImageView stateImageView;
        private final ImageView stateIcon;
        private final GeneralInterface.OnLessonItemListener onLessonItemListener;

        public ViewHolder(@NonNull View view, GeneralInterface.OnLessonItemListener onLessonItemListener) {
            super(view);

            numberLessonTV = view.findViewById(R.id.lesson_number);
            nameLessonTV = view.findViewById(R.id.lesson_name);
            durationTV = view.findViewById(R.id.duration_tv);
            stateImageView = view.findViewById(R.id.state_img);
            stateIcon = view.findViewById(R.id.state_ic);
            this.onLessonItemListener = onLessonItemListener;

            view.setOnClickListener(this);
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

        @Override
        public void onClick(View view) {
            onLessonItemListener.onLessonClick(view, getAdapterPosition());
        }
    }

    public LessonAdapter(ArrayList<Lesson> arrayList, GeneralInterface.OnLessonItemListener onLessonItemListener) {
        arrayListLesson = arrayList;
        this.mOnLessonItemListener = onLessonItemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lesson_item, parent, false);
        return new ViewHolder(view, mOnLessonItemListener);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lesson item = arrayListLesson.get(position);

        holder.getNumberLessonTV().setText(
                item.getLessonNumber() < 10 ?
                        "0" + item.getLessonNumber() :
                        String.valueOf(item.getLessonNumber())
        );
        holder.getNameLessonTV().setText(item.getLessonName());
        holder.getDurationTV().setText(holder.itemView.getContext().getResources().getString(R.string.totalDuration, item.getDuration()));
        holder.getStateImageView().setImageResource(item.getState() ? R.drawable.done_button_background : R.drawable.undone_button_background);
        holder.getStateIcon().setImageResource(item.getState() ? R.drawable.ic_check : R.drawable.ic_play_arrow);
    }

    @Override
    public int getItemCount() {
        return arrayListLesson.size();
    }
}
