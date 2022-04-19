package com.example.els.fragment.authentication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.els.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.phoneLogin.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(LoginFragmentDirections.actionLoginFragmentToPhoneLoginFragment()));
        binding.loginBtn.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment()));
        binding.signupTv.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment()));
    }
}