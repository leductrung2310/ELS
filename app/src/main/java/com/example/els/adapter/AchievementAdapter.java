package com.example.els.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.els.R;

import java.util.List;

public class AchievementAdapter extends ArrayAdapter<Integer> {

    public AchievementAdapter(@NonNull Context context, int resource, @NonNull List<Integer> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.personal_achievement_item, parent, false);
        }
        int id = getItem(position);
        ImageView imageView = listItemView.findViewById(R.id.personal_achievement_item_image);
        imageView.setImageResource(id);
        return listItemView;
    }
}
