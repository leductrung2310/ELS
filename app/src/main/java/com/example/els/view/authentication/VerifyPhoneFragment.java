package com.example.els.view.authentication;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.els.R;
import com.example.els.databinding.FragmentVerifyPhoneBinding;
import com.example.els.viewmodel.authentication.PhoneLoginViewmodel;

public class VerifyPhoneFragment extends Fragment {

    FragmentVerifyPhoneBinding binding;
    PhoneLoginViewmodel phoneLoginViewmodel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentVerifyPhoneBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        phoneLoginViewmodel = new ViewModelProvider(requireActivity()).get(PhoneLoginViewmodel.class);
        phoneLoginViewmodel.getUserLiveData().observe(getViewLifecycleOwner(), firebaseUser -> {
            if (firebaseUser != null) {
                Navigation.findNavController(view).navigate(R.id.action_verifyPhoneFragment_to_homeFragment);
            }
        });
        phoneLoginViewmodel.getIsOnCodeSent().observe(getViewLifecycleOwner(), isSent -> {
            if(!isSent) {
                Navigation.findNavController(view).navigate(R.id.action_verifyPhoneFragment_to_phoneLoginFragment);
            }
        });

        phoneLoginViewmodel.getPhoneNumber().observe(getViewLifecycleOwner(), s -> {
            binding.phoneNumberVerify.setText(s);
        });

        binding.backButton.setOnClickListener(view1 -> phoneLoginViewmodel.getIsOnCodeSent().setValue(false));

        setupOTPInputs();
        binding.verifyBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View view) {
                phoneLoginViewmodel.verifyOtp(getVerificationId(), requireActivity().getApplication());
            }
        });
    }

    private void setupOTPInputs() {
        binding.inputCode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    binding.inputCode2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.inputCode2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    binding.inputCode3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.inputCode3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    binding.inputCode4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.inputCode4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    binding.inputCode5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.inputCode5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    binding.inputCode6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        binding.inputCode6.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == KeyEvent.KEYCODE_DEL) {
                    Log.d("key", "1");
                    binding.inputCode5.requestFocus();
                }
                return false;
            }
        });
        binding.inputCode5.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == KeyEvent.KEYCODE_DEL) {
                    binding.inputCode4.requestFocus();
                    Log.d("key", "2");
                }
                return false;
            }
        });
        binding.inputCode4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == KeyEvent.KEYCODE_DEL) {
                    binding.inputCode3.requestFocus();
                    Log.d("key", "3");
                }
                return false;
            }
        });
        binding.inputCode3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == KeyEvent.KEYCODE_DEL) {
                    binding.inputCode2.requestFocus();
                    Log.d("key", "4");
                }
                return false;
            }
        });
        binding.inputCode2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == KeyEvent.KEYCODE_DEL) {
                    binding.inputCode1.requestFocus();
                }
                return false;
            }
        });
    }

    private String getVerificationId() {
        return binding.inputCode1.getText().toString() +
                binding.inputCode2.getText().toString() +
                binding.inputCode3.getText().toString() +
                binding.inputCode4.getText().toString() +
                binding.inputCode5.getText().toString() +
                binding.inputCode6.getText().toString();
    }
}