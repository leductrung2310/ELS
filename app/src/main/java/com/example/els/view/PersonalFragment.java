package com.example.els.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.els.R;
import com.example.els.databinding.FragmentPersonalBinding;

public class PersonalFragment extends Fragment {
    private FragmentPersonalBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_personal, container, false);

        binding = FragmentPersonalBinding.inflate(getLayoutInflater());
//        binding.personalTabSetting1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getContext(), InformationActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        binding.personalSetting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getContext(), SettingActivity.class);
//                startActivity(intent);
//            }
//        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.personalTabSetting1.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(PersonalFragmentDirections.actionPersonalFragmentToInformationFragment()));
        binding.personalTabSetting2.setOnClickListener(view12 -> Navigation.findNavController(view12).navigate(PersonalFragmentDirections.actionPersonalFragmentToAchievementFragment()));
        binding.personalTabSetting3.setOnClickListener(view13 -> Navigation.findNavController(view13).navigate(PersonalFragmentDirections.actionPersonalFragmentToNewspaperFragment()));
        binding.personalSetting.setOnClickListener(view14 -> Navigation.findNavController(view14).navigate(PersonalFragmentDirections.actionPersonalFragmentToSettingFragment()));
        binding.personalTabSetting4.setOnClickListener(view15 -> Navigation.findNavController(view15).navigate(R.id.action_personalFragment_to_loginFragment));
    }
}