package com.example.els.view.personal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.els.R;
import com.example.els.adapter.AchievementAdapter;
import com.example.els.databinding.FragmentAchievementBinding;

import java.util.ArrayList;

public class AchievementFragment extends Fragment {
    private FragmentAchievementBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAchievementBinding.inflate(getLayoutInflater());

        ArrayList<Integer> courseModelArrayList = new ArrayList<Integer>();
        courseModelArrayList.add(R.drawable.gamipress_icon_add);
        courseModelArrayList.add(R.drawable.gamipress_icon_comment);
        courseModelArrayList.add(R.drawable.gamipress_icon_heart);
        courseModelArrayList.add(R.drawable.gamipress_icon_minus);
        courseModelArrayList.add(R.drawable.gamipress_icon_pencil);
        courseModelArrayList.add(R.drawable.gamipress_icon_quest);
        courseModelArrayList.add(R.drawable.gamipress_icon_search);
        courseModelArrayList.add(R.drawable.gamipress_icon_star);
        AchievementAdapter achievementAdapter = new AchievementAdapter(requireContext(),0,courseModelArrayList);

        binding.idGVcourses.setAdapter(achievementAdapter);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.personalAchievementBack.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.action_achievementFragment_to_personalFragment));
    }
}