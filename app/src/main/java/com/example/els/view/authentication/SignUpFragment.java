package com.example.els.view.authentication;


import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.els.R;
import com.example.els.models.ELSUser;
import com.example.els.viewmodel.authentication.SignUpViewmodel;

public class SignUpFragment extends Fragment {

    FragmentSignUpBinding binding;
    private SignUpViewmodel signUpViewmodel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSignUpBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        signUpViewmodel = new ViewModelProvider(this).get(SignUpViewmodel.class);
        signUpViewmodel.getIsRegisterSuccessLiveData().observe(getViewLifecycleOwner(), aBoolean -> {
            if(aBoolean) {
                Navigation.findNavController(getView()).navigate(R.id.action_signUpFragment_to_loginFragment);
            }
        });

        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View view) {
                    String email = binding.email.getText().toString();
                String password = binding.password.getText().toString();

                ELSUser newUser = new ELSUser();
                newUser.setName(binding.name.getText().toString());
                newUser.setAge("0");
                newUser.setGender("");
                newUser.setPosition("");
                newUser.setPhoneNumber("");

                if(checkEmpty()) {
                    signUpViewmodel.register(email, password, newUser);
                }
            }
        });
    }

    public boolean checkEmpty(){
        if(binding.name.getText() == null) {
            Toast.makeText(getContext(), "Invalid Username", Toast.LENGTH_SHORT).show();
            binding.name.requestFocus();
            return false;
        }
        if(binding.email.getText() == null) {
            Toast.makeText(getContext(), "Invalid Email", Toast.LENGTH_SHORT).show();
            binding.name.requestFocus();
            return false;
        }
        if(binding.password.getText() == null) {
            Toast.makeText(getContext(), "Invalid Password", Toast.LENGTH_SHORT).show();
            binding.name.requestFocus();
            return false;
        }
        if(!binding.confirmPassword.getText().toString().equals(binding.password.getText().toString())) {
            Toast.makeText(getContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
            binding.name.requestFocus();
            return false;
        }
        return true;
    }
}