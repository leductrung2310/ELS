package com.example.els.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.els.databinding.FragmentPersonalBinding;

public class PersonalFragment extends Fragment {
    FragmentPersonalBinding binding;
    public PersonalFragment() {

    }


    public static PersonalFragment newInstance(String param1, String param2) {
        PersonalFragment fragment = new PersonalFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
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

        binding.personalTabSetting1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(PersonalFragmentDirections.actionPersonalFragmentToInformationFragment());
            }
        });
        binding.personalTabSetting2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(PersonalFragmentDirections.actionPersonalFragmentToAchievementFragment());
            }
        });

        binding.personalTabSetting3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(PersonalFragmentDirections.actionPersonalFragmentToNewspaperFragment());
            }
        });

        binding.personalSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(PersonalFragmentDirections.actionPersonalFragmentToSettingFragment());
            }
        });
    }
}