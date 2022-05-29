package com.example.els.view;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.els.adapter.MeaningListviewAdapter;
import com.example.els.databinding.FragmentMeetingBinding;
import com.example.els.databinding.MeaningItemBinding;
import com.example.els.models.dictionary.Meaning;
import com.example.els.models.dictionary.Word;
import com.example.els.viewmodel.DictionaryViewmodel;

import java.io.IOException;
import java.util.List;

public class DictionaryFragment extends Fragment {
    private FragmentMeetingBinding binding;
    private MeaningItemBinding meaningItemBinding;
    private DictionaryViewmodel dictionaryViewmodel;
    String phoneticUrl;
    MeaningListviewAdapter adapter;

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

        //check empty search or first search
        if(dictionaryViewmodel.getNewWordLiveData().getValue() == null) {
            binding.bodyLayout.setVisibility(View.GONE);
        }

        //search engine
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dictionaryViewmodel.getWord(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        dictionaryViewmodel.getNewWordLiveData().observe(getViewLifecycleOwner(), new Observer<Word>() {
            @Override
            public void onChanged(Word word) {
                if (word != null) {
                    binding.bodyLayout.setVisibility(View.VISIBLE);
                    binding.word.setText(word.getWord());
                    for (int i = 0; i < word.getPhonetics().size(); i++) {
                        if (!word.getPhonetics().get(i).getAudio().equals("") && !word.getPhonetics().get(i).getText().equals("")) {
                            binding.phonetic.setText(word.getPhonetics().get(i).getText());
                            phoneticUrl = word.getPhonetics().get(i).getAudio();
                        }
                    }

                    //list meaning listview
                    List<Meaning> meanings = dictionaryViewmodel.getNewWordLiveData().getValue().getMeanings();
                    adapter = new MeaningListviewAdapter(meanings);

                    binding.listMeanings.setAdapter(adapter);
                }
            }
        });

        // phonetic sound
        binding.phoneticSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioAttributes(
                        new AudioAttributes.Builder()
                                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                .setUsage(AudioAttributes.USAGE_MEDIA)
                                .build()
                );
                try {
                    mediaPlayer.setDataSource(phoneticUrl);
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
            }
        });


        //listMeanings.setAdapter(meaningListViewAdapter);
    }
}