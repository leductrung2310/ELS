package com.example.els.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.els.R;
import com.example.els.models.Achievement;

import java.util.List;

public class AchievementAdapter extends ArrayAdapter<Achievement> {

    public AchievementAdapter(@NonNull Context context, int resource, @NonNull List<Achievement> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.personal_achievement_item, parent, false);
        }
        Achievement id = getItem(position);
        ImageView imageView = listItemView.findViewById(R.id.personal_achievement_item_image);
        TextView textView = listItemView.findViewById(R.id.personal_achievement_item_textview);
        imageView.setImageResource(id.getImage());
        textView.setText(id.getName());
        return listItemView;
    }
}
