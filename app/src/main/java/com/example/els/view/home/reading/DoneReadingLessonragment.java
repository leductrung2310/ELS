package com.example.els.view.home.reading;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.els.R;
import com.example.els.adapter.home.DoneReadingLessonAdapter;
import com.example.els.databinding.FragmentDoneReadingLessonragmentBinding;
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
    private DoneReadingLessonAdapter doneReadingLessonAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDoneReadingLessonragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        readingViewModel = new ViewModelProvider(requireActivity()).get(ReadingViewModel.class);

        binding.backBtn.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.action_doneReadingLessonragment_to_skillsFragment));

        _readingAnswers = new ArrayList<>();
        MutableLiveData<List<ReadingAnswer>> _readingAnswersLiveDate = new MutableLiveData<>();


        readingViewModel.getReadingAnswerLiveData().observe(getViewLifecycleOwner(), readingAnswers -> {
            _readingAnswers.add(readingAnswers.get(0));
            doneReadingLessonAdapter = new DoneReadingLessonAdapter(readingViewModel.getReadingQuestionsLiveDate().getValue(), _readingAnswers);
            binding.rcvListeningQuestion.setAdapter(doneReadingLessonAdapter);
        });
        Objects.requireNonNull(readingViewModel.getReadingQuestionsLiveDate().getValue()).forEach(readingQuestion -> {
            readingViewModel.getCorrectReadingAnswerByReadingQuestion(readingQuestion.getUuid());
        });


        readingViewModel.getDoneReadingLessonFromFirebase().observe(getViewLifecycleOwner(), readingFirebases -> {
            for (ReadingFirebase readingFirebase: readingFirebases) {
                String firstId =  readingFirebase.getId();
                String secondId =  Objects.requireNonNull(readingViewModel.getReadingLessonLiveData().getValue()).get(readingViewModel.getPosition()).getUuid();
                if (Objects.equals(firstId, secondId)) {
                    binding.score.setText(readingFirebase.getScore());
                }
            }
        });
    }
}