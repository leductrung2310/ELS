package com.example.els.view.authentication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.els.R;
import com.example.els.databinding.FragmentPhoneLoginBinding;
import com.example.els.models.authentication.PhoneAccountRepository;

public class PhoneLoginFragment extends Fragment {

    private FragmentPhoneLoginBinding binding;

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
        binding.backButtonPhoneLogin.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.action_phoneLoginFragment_to_loginFragment));
    }

    public void OnClickPhoneRequest() {
        PhoneAccountRepository phoneAccountRepository = new PhoneAccountRepository();

        if(!phoneAccountRepository.isValidPhoneNumber()) {
           // messageInvalidPhoneNumber.set("Invalid Phone Number");
        } else {

        }
    }
}