package com.example.els.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.els.InformationActivity;
import com.example.els.R;
import com.example.els.databinding.FragmentPersonalBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PersonalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonalFragment extends Fragment {
    FragmentPersonalBinding binding;
    public PersonalFragment() {

    }


    public static PersonalFragment newInstance(String param1, String param2) {
        PersonalFragment fragment = new PersonalFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_personal, container, false);

        binding = FragmentPersonalBinding.inflate(getLayoutInflater());
        binding.personalTabSetting1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), InformationActivity.class);
                startActivity(intent);
            }
        });

        Log.d("D","CLick1");

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.bSearch.setOnClickListener(view1 -> Log.d("D","CLick"));
    }
}