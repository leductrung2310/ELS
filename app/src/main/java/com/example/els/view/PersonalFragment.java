package com.example.els.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.els.R;
import com.example.els.databinding.FragmentPersonalBinding;
import com.example.els.models.authentication.GeneralUser;
import com.example.els.models.authentication.LoginType;
import com.example.els.viewmodel.authentication.EmailLoginViewmodel;
import com.example.els.viewmodel.authentication.PhoneLoginViewmodel;

public class PersonalFragment extends Fragment {
    private FragmentPersonalBinding binding;
    private EmailLoginViewmodel emailLoginViewmodel;
    private PhoneLoginViewmodel phoneLoginViewmodel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPersonalBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (LoginType.getInstance().getLoginType() == 0) {
            emailLoginViewmodel = new ViewModelProvider(requireActivity()).get(EmailLoginViewmodel.class);
            emailLoginViewmodel.getIsLoggOutLiveData().observe(getViewLifecycleOwner(), isLogOut -> {
                if (isLogOut) {
                    Toast.makeText(getContext(), "User Logged Out", Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(requireView()).navigate(R.id.action_personalFragment_to_loginFragment);
                }
            });

        } else if (LoginType.getInstance().getLoginType() == 1) {
            phoneLoginViewmodel = new ViewModelProvider(requireActivity()).get(PhoneLoginViewmodel.class);
            phoneLoginViewmodel.getIsLoggOutLiveData().observe(getViewLifecycleOwner(), isLogOut -> {
                if (isLogOut) {
                    Toast.makeText(getContext(), "User Logged Out", Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(requireView()).navigate(R.id.action_personalFragment_to_loginFragment);
                }
            });
        }

        binding.personalTabSetting1.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(PersonalFragmentDirections.actionPersonalFragmentToInformationFragment()));
        binding.personalTabSetting2.setOnClickListener(view12 -> Navigation.findNavController(view12).navigate(PersonalFragmentDirections.actionPersonalFragmentToAchievementFragment()));
        //binding.personalTabSetting3.setOnClickListener(view13 -> Navigation.findNavController(view13).navigate(PersonalFragmentDirections.actionPersonalFragmentToNewspaperFragment()));
        binding.personalSetting.setOnClickListener(view14 -> Navigation.findNavController(view14).navigate(PersonalFragmentDirections.actionPersonalFragmentToSettingFragment()));

        binding.personalTabSetting4.setOnClickListener(view15 -> {
            if (LoginType.getInstance().getLoginType() == 0) {
                emailLoginViewmodel.logOut();
            } else if (LoginType.getInstance().getLoginType() == 1) {
                phoneLoginViewmodel.logOut();
            }
        });

        //get user data
        binding.personalName.setText( GeneralUser.getInstance().getUserName());
        binding.personalPhoneNumber.setText(GeneralUser.getInstance().getPhoneNumber());
        binding.personalPosition.setText(GeneralUser.getInstance().getPosition());
    }
}