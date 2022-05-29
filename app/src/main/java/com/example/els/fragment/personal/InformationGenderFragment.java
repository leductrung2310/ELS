package com.example.els.fragment.personal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.els.R;
import com.example.els.databinding.FragmentInformationGenderBinding;
import com.example.els.models.authentication.GeneralUser;
import com.example.els.viewmodel.PersonalViewmodel;

public class InformationGenderFragment extends Fragment {
    private FragmentInformationGenderBinding binding;
    private PersonalViewmodel personalViewmodel;
    private String newGender;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInformationGenderBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        personalViewmodel = new ViewModelProvider(requireActivity()).get(PersonalViewmodel.class);

        binding.personalEditInfoGenderBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_informationGenderFragment_to_informationFragment);
            }
        });

        personalViewmodel.getIsEditGenderSuccess().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean) {
                    Toast.makeText(getContext(), "Edit Gender Successfully", Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(view).navigate(R.id.action_informationGenderFragment_to_informationFragment);
                    personalViewmodel.getIsEditGenderSuccess().setValue(false);
                }
            }
        });

//        binding.personalEditInfoGenderRadioButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                boolean checked = ((RadioButton) view).isChecked();
//
//                switch (view.getId()) {
//                    case R.id.male_choice:
//                        if (checked)
//                            newGender = "Male";
//                        break;
//                    case R.id.female_choice:
//                        if (checked)
//                            newGender = "Female";
//                        break;
//                    case R.id.others_choice:
//                        if (checked)
//                            newGender = "Others";
//                        break;
//                }
//            }
//        });

        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = binding.personalEditInfoGenderRadioButton.getCheckedRadioButtonId();

                RadioButton radioButton = (RadioButton) getView().findViewById(selectedId);
                newGender = radioButton.getText().toString();
            }
        });

        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editGender(newGender);
            }
        });
    }

    void editGender(String gender) {
        GeneralUser.getInstance().setGender(gender);
        personalViewmodel.editGender(gender, getActivity().getApplication());
    }
}