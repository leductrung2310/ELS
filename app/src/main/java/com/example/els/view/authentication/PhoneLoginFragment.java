package com.example.els.view.authentication;

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
import com.example.els.databinding.FragmentPhoneLoginBinding;
import com.example.els.viewmodel.authentication.PhoneLoginViewmodel;
import com.google.firebase.auth.FirebaseUser;

public class PhoneLoginFragment extends Fragment {

    private FragmentPhoneLoginBinding binding;
    private PhoneLoginViewmodel phoneLoginViewmodel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPhoneLoginBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        phoneLoginViewmodel = new ViewModelProvider(requireActivity()).get(PhoneLoginViewmodel.class );
        phoneLoginViewmodel.getUserLiveData().observe(getViewLifecycleOwner(), new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if(firebaseUser != null) {
                    Navigation.findNavController(getView()).navigate(R.id.action_phoneLoginFragment_to_homeFragment);
                }
            }
        });
        phoneLoginViewmodel.getIsOnCodeSent().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean) {
                    Navigation.findNavController(getView()).navigate(R.id.action_phoneLoginFragment_to_verifyPhoneFragment);
                }
            }
        });

        binding.backButtonPhoneLogin.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.action_phoneLoginFragment_to_loginFragment));
        binding.requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickPhoneRequest(binding.phoneNumber.getText().toString());
            }
        });

    }

    public void OnClickPhoneRequest(String phoneNumber) {

        if(phoneNumber.length() == 9 || phoneNumber.length() == 10 ) {
            phoneLoginViewmodel.setPhoneNumber(phoneNumber);
            phoneLoginViewmodel.sendOtpCode(phoneNumber, this.getActivity(), getActivity().getApplication());
        } else {
            Toast.makeText(getContext(), "Invalid Phone Number!", Toast.LENGTH_LONG).show();
        }
    }
}