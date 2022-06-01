package com.example.els.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.els.R;
import com.example.els.models.games.History;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private final ArrayList<History> histories;

    /*
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView scoreTextView;
        private final TextView levelAndAreaTextView;
        private final TextView dateTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            scoreTextView = itemView.findViewById(R.id.score_tv);
            levelAndAreaTextView = itemView.findViewById(R.id.level_and_area);
            dateTextView = itemView.findViewById(R.id.date);
        }
    }

    /*
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public HistoryAdapter(ArrayList<History> histories) {
        this.histories = histories;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_item, parent, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        History history = histories.get(position);

        @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");

        String score = holder.itemView.getContext().getString(R.string.score, history.getScore());
        String levelAndArea = holder.itemView.getContext().getString(R.string.history_item_title, history.getArea(), history.getLevel());
        String date = dateFormat.format(history.getDate());

        holder.scoreTextView.setText(score);
        holder.levelAndAreaTextView.setText(levelAndArea);
        holder.dateTextView.setText(date);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return histories.size();
    }
}
