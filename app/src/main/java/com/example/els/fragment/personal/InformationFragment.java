package com.example.els.fragment.personal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.els.R;
import com.example.els.databinding.FragmentInformationBinding;
import com.example.els.databinding.FragmentPersonalBinding;
import com.example.els.fragment.PersonalFragmentDirections;


public class InformationFragment extends Fragment {
    private FragmentInformationBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInformationBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.personalEditInfoBack.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.action_informationFragment_to_personalFragment));

        binding.personalInfoNameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(InformationFragmentDirections.actionInformationFragmentToInformationNameFragment());
            }
        });
    }
}