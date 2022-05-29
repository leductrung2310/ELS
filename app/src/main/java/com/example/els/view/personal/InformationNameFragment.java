package com.example.els.view.personal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.els.R;
import com.example.els.databinding.FragmentInformationNameBinding;
import com.example.els.viewmodel.PersonalViewmodel;

public class InformationNameFragment extends Fragment {
    private FragmentInformationNameBinding binding;
    private PersonalViewmodel personalViewmodel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInformationNameBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        personalViewmodel = new ViewModelProvider(requireActivity()).get(PersonalViewmodel.class);
        personalViewmodel.getIsEditNameSuccess().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean) {
                    Toast.makeText(getContext(), "Edit Name Successfully", Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(getView()).navigate(R.id.action_informationNameFragment_to_informationFragment);
                    personalViewmodel.getIsEditNameSuccess().setValue(false);
                }
            }
        });

        binding.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personalViewmodel.editUserName(binding.nameChanged.getText().toString(), getActivity().getApplication());
            }
        });

        binding.personalEditInfoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getView()).navigate(R.id.action_informationNameFragment_to_informationFragment);
            }
        });

    }
}