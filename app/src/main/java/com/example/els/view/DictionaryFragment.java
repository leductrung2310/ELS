package com.example.els.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.els.databinding.FragmentMeetingBinding;
import com.example.els.models.dictionary.Word;
import com.example.els.viewmodel.DictionaryViewmodel;

public class DictionaryFragment extends Fragment {
    private FragmentMeetingBinding binding;
    private DictionaryViewmodel dictionaryViewmodel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMeetingBinding.inflate(getLayoutInflater());


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dictionaryViewmodel = new ViewModelProvider(requireActivity()).get(DictionaryViewmodel.class);

//        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                dictionaryViewmodel.getWord(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });

        dictionaryViewmodel.getNewWordLiveData().observe(getViewLifecycleOwner(), new Observer<Word>() {
            @Override
            public void onChanged(Word word) {
                if(word != null ) {
                    binding.word.setText(word.getWord());
                    binding.phonetic.setText(word.getPhonetic());
                }
            }
        });

        binding.phoneticSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dictionaryViewmodel.getWord("apple");
            }
        });
    }
}