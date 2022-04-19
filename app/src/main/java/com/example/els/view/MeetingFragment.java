package com.example.els.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.els.R;
import com.example.els.adapter.AchievementAdapter;
import com.example.els.adapter.MeetingRoomAdapter;
import com.example.els.databinding.FragmentMeetingBinding;

import java.util.ArrayList;

public class MeetingFragment extends Fragment {
    private FragmentMeetingBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMeetingBinding.inflate(getLayoutInflater());

        ArrayList<String> nameRoom = new ArrayList<String>();
        nameRoom.add("Room 1");
        nameRoom.add("Room 2");
        nameRoom.add("Room 3");
        nameRoom.add("Room 4");
        nameRoom.add("Room 5");
        nameRoom.add("Room 6");
        nameRoom.add("Room 7");
        nameRoom.add("Room 8");
        nameRoom.add("Room 9");
        nameRoom.add("Room 10");

        MeetingRoomAdapter meetingRoomAdapter = new MeetingRoomAdapter(requireContext(),0,nameRoom);

        binding.meetingGridRoom.setAdapter(meetingRoomAdapter);

        return binding.getRoot();
    }
}