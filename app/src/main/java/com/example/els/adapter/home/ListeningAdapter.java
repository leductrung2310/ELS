package com.example.els.adapter.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.els.R;
import com.example.els.component.GeneralInterface;
import com.example.els.models.Api.Listening;

import java.util.ArrayList;
import java.util.List;

public class ListeningAdapter extends RecyclerView.Adapter<ListeningAdapter.ViewHolder> {
    private final ArrayList<Listening> listenings = new ArrayList<>();
    private Context context;
    private final GeneralInterface.OnLessonItemListener mOnLessonItemListener;

    public ListeningAdapter(Context context, List<Listening> list, GeneralInterface.OnLessonItemListener onLessonItemListener) {
        this.listenings.addAll(list);
        this.context = context;
        this.mOnLessonItemListener = onLessonItemListener;
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
        Listening listening= listenings.get(position);
        holder.numberLessonTV.setText(String.valueOf(position+1));
        holder.nameLessonTV.setText(listening.getTitle());
        holder.durationTV.setText(listening.getDuration() + " seconds");

    }

    @Override
    public int getItemCount() {
        return listenings.size();
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
