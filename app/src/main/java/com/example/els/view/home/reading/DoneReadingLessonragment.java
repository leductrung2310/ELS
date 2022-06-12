package com.example.els.view.home.reading;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.els.R;
import com.example.els.adapter.home.DoneReadingLessonAdapter;
import com.example.els.databinding.FragmentDoneReadingLessonragmentBinding;
import com.example.els.models.Api.ReadingAnswer;
import com.example.els.models.Api.ReadingFirebase;
import com.example.els.models.Api.ReadingQuestion;
import com.example.els.viewmodel.home.ReadingViewModel;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DoneReadingLessonragment extends Fragment {
    private FragmentDoneReadingLessonragmentBinding binding;
    private ReadingViewModel readingViewModel;
    private ArrayList<ReadingAnswer> _readingAnswers;
    private DoneReadingLessonAdapter doneReadingLessonAdapter;

    int i = 0;


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


        binding.lqAnswer1.setBackgroundResource(R.color.white_3);
        binding.lqAnswer2.setBackgroundResource(R.color.white_3);
        binding.lqAnswer3.setBackgroundResource(R.color.white_3);
        binding.lqAnswer4.setBackgroundResource(R.color.white_3);
        showAnswer(0);

        _readingAnswers = new ArrayList<>();



//        readingViewModel.getReadingAnswerLiveDataDone().observe(getViewLifecycleOwner(), new Observer<List<ReadingAnswer>>() {
//            @Override
//            public void onChanged(List<ReadingAnswer> readingAnswers) {
//                _readingAnswers.add(readingAnswers.get(0));
////                doneReadingLessonAdapter = new DoneReadingLessonAdapter(readingViewModel.getReadingQuestionsLiveDate().getValue(), _readingAnswers);
////                binding.rcvListeningQuestion.setAdapter(doneReadingLessonAdapter);
//            }
//        });
////        readingViewModel.getReadingQuestionsLiveDate().getValue().forEach(readingQuestion -> {
////            readingViewModel.getCorrectReadingAnswerByReadingQuestion(readingQuestion.getUuid());
////        });
//        readingViewModel.getReadingQuestionLiveDataDone().observe(getViewLifecycleOwner(), new Observer<List<ReadingQuestion>>() {
//            @Override
//            public void onChanged(List<ReadingQuestion> readingQuestions) {
//                for (ReadingQuestion readingquestion: readingQuestions
//                     ) {
//                    readingViewModel.getCorrectReadingAnswerByReadingQuestion(readingquestion.getUuid());
//                }
//            }
//        });

        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.startButton.getText() == "Finish") {

                }
                if ( i < readingViewModel.getReadingQuestionLiveDataDone().getValue().size()) {

                    showAnswer(i);
                    binding.lqAnswer1.setBackgroundResource(R.color.white_3);
                    binding.lqAnswer2.setBackgroundResource(R.color.white_3);
                    binding.lqAnswer3.setBackgroundResource(R.color.white_3);
                    binding.lqAnswer4.setBackgroundResource(R.color.white_3);
                    if (i == readingViewModel.getReadingQuestionLiveDataDone().getValue().size()) {
                        binding.startButton.setText("Finish");
                    }
                }
                binding.radioButton.clearCheck();
            }
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

    private void showAnswer(int i) {
        readingViewModel.getReadingQuestionLiveDataDone().observe(getViewLifecycleOwner(), new Observer<List<ReadingQuestion>>() {
            @Override
            public void onChanged(List<ReadingQuestion> readingQuestions) {
                readingViewModel.setReadingQuestion(readingQuestions.get(i));
                readingViewModel.getReadingAnswerByReadingQuestion((readingQuestions.get(i).getUuid()));
                binding.itemLq1.setText(readingQuestions.get(i).getContent());
            }
        });
        readingViewModel.getReadingAnswerLiveDataDone().observe(getViewLifecycleOwner(), new Observer<List<ReadingAnswer>>() {
            @Override
            public void onChanged(List<ReadingAnswer> readingAnswers) {
                Log.d("string",""+ readingAnswers.size());
                binding.lqAnswer1.setText(readingAnswers.get(0).getAnswer());
                binding.lqAnswer2.setText(readingAnswers.get(1).getAnswer());
                binding.lqAnswer3.setText(readingAnswers.get(2).getAnswer());
                binding.lqAnswer4.setText(readingAnswers.get(3).getAnswer());
                binding.lqAnswer1.setBackgroundResource(R.color.white_3);
                binding.lqAnswer2.setBackgroundResource(R.color.white_3);
                binding.lqAnswer3.setBackgroundResource(R.color.white_3);
                binding.lqAnswer4.setBackgroundResource(R.color.white_3);
                if (readingAnswers.get(0).isCorrect()) {
                 binding.lqAnswer1.setBackgroundResource(R.color.primary_color);
                }
                if (readingAnswers.get(1).isCorrect()) {
                    binding.lqAnswer2.setBackgroundResource(R.color.primary_color);
                }
                if (readingAnswers.get(2).isCorrect()) {
                    binding.lqAnswer3.setBackgroundResource(R.color.primary_color);
                }
                if (readingAnswers.get(3).isCorrect()) {
                    binding.lqAnswer4.setBackgroundResource(R.color.primary_color);
                }
            }
        });
        this.i++;

    }

    @Override
    public void onPause() {
        super.onPause();
    }
}