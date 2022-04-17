package com.example.els.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.els.R;

import java.util.List;

public class MeetingRoomAdapter extends ArrayAdapter<String> {

    public MeetingRoomAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.meeting_room, parent, false);
        }
        String id = getItem(position);
        TextView textView = listItemView.findViewById(R.id.meeting_room_tv);
        textView.setText(id);
        return listItemView;
    }
}
