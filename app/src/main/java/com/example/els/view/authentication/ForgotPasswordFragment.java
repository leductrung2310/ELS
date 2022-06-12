package com.example.els.view.authentication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.els.R;
import com.example.els.databinding.FragmentForgotPasswordBinding;
import com.example.els.viewmodel.authentication.ForgotPasswordViewmodel;

public class ForgotPasswordFragment extends Fragment {

    FragmentForgotPasswordBinding binding;
    ForgotPasswordViewmodel forgotPasswordViewmodel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding =  FragmentForgotPasswordBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        forgotPasswordViewmodel = new ViewModelProvider(requireActivity()).get(ForgotPasswordViewmodel.class);
        binding.requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Aaa", binding.resetPassword.getText().toString());
                Log.d("Aaa1", getActivity().getApplication().toString());
                forgotPasswordViewmodel.resetPassword(binding.resetPassword.getText().toString(), getActivity().getApplication());
            }
        });

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_forgotPasswordFragment_to_loginFragment);
            }
        });
    }
}