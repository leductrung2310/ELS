package com.example.els.view.home.reading;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.els.R;
import com.example.els.adapter.home.DoneListeningAdapter;
import com.example.els.adapter.home.DoneReadingLessonAdapter;
import com.example.els.databinding.FragmentDoneReadingLessonragmentBinding;
import com.example.els.databinding.FragmentReadingQuestionBinding;
import com.example.els.models.Api.ListeningFirebase;
import com.example.els.models.Api.ReadingAnswer;
import com.example.els.models.Api.ReadingFirebase;
import com.example.els.viewmodel.home.ReadingViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DoneReadingLessonragment extends Fragment {
    private FragmentDoneReadingLessonragmentBinding binding;
    private ReadingViewModel readingViewModel;
    private ArrayList<ReadingAnswer> _readingAnswers;
    private MutableLiveData<List<ReadingAnswer>> _readingAnswersLiveDate;
    private DoneReadingLessonAdapter doneReadingLessonAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDoneReadingLessonragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        readingViewModel = new ViewModelProvider(requireActivity()).get(ReadingViewModel.class);

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_doneReadingLessonragment_to_skillsFragment);
            }
        });

        _readingAnswers = new ArrayList<>();
        _readingAnswersLiveDate = new MutableLiveData<>();


        readingViewModel.getReadingAnswerLiveData().observe(getViewLifecycleOwner(), new Observer<List<ReadingAnswer>>() {
            @Override
            public void onChanged(List<ReadingAnswer> readingAnswers) {
                _readingAnswers.add(readingAnswers.get(0));
                doneReadingLessonAdapter = new DoneReadingLessonAdapter(readingViewModel.getReadingQuestionsLiveDate().getValue(), _readingAnswers);
                binding.rcvListeningQuestion.setAdapter(doneReadingLessonAdapter);
            }
        });
        readingViewModel.getReadingQuestionsLiveDate().getValue().forEach(readingQuestion -> {
            readingViewModel.getCorrectReadingAnswerByReadingQuestion(readingQuestion.getUuid());
        });


        readingViewModel.getDoneReadingLessonFromFirebase().observe(getViewLifecycleOwner(), new Observer<ArrayList<ReadingFirebase>>() {
            @Override
            public void onChanged(ArrayList<ReadingFirebase> readingFirebases) {
                for (ReadingFirebase readingFirebase: readingFirebases) {
                    String firstId =  readingFirebase.getId();
                    String secondId =  readingViewModel.getReadingLessonLiveData().getValue().get(readingViewModel.getPosition()).getUuid();
                    if (Objects.equals(firstId, secondId)) {
                        binding.score.setText(readingFirebase.getScore());
                    }
                }
            }
        });
    }
}