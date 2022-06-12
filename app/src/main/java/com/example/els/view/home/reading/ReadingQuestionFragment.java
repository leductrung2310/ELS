package com.example.els.view.home.reading;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.els.R;
import com.example.els.databinding.FragmentLessonObjectBinding;
import com.example.els.databinding.FragmentReadingQuestionBinding;
import com.example.els.models.Api.ReadingAnswer;
import com.example.els.models.Api.ReadingQuestion;
import com.example.els.viewmodel.home.ReadingViewModel;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.List;

public class ReadingQuestionFragment extends Fragment {
    private FragmentReadingQuestionBinding binding;
    private ReadingViewModel readingViewModel;
    int i = 0;
    int score = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentReadingQuestionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        readingViewModel = new ViewModelProvider(requireActivity()).get(ReadingViewModel.class);

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_readingQuestionFragment_to_skillsFragment);
            }
        });
        showAnswer(i);

        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.startButton.getText() == "Finish") {
                    int selectedId = binding.radioButton.getCheckedRadioButtonId();

                    if (selectedId != -1) {
                        // find the radiobutton by returned id
                        RadioButton radioButton = binding.radioButton.findViewById(selectedId);
                        readingViewModel.getReadingAnswerLiveData().getValue().forEach(readingAnswer -> {
                            if(radioButton.getText().toString().equals(readingAnswer.getAnswer()) && readingAnswer.isCorrect()) {
                                score+=10;
                            }
                        });
                    }
                    MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(getContext());
                    materialAlertDialogBuilder.setTitle("Do you want to finish the lesson");
                    materialAlertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(getContext());
                            materialAlertDialogBuilder.setTitle("Lesson result");
                            materialAlertDialogBuilder.setMessage("Your score: " + score+ " points");
                            materialAlertDialogBuilder.setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    readingViewModel.pushDoneReadingLessonToFirestore(score);
                                    Navigation.findNavController(view).navigate(R.id.action_readingQuestionFragment_to_skillsFragment);
                                }
                            });
                            materialAlertDialogBuilder.show();
                        }
                    });
                    materialAlertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    materialAlertDialogBuilder.show();
                }
                if ( i < readingViewModel.getReadingQuestionsLiveDate().getValue().size()) {
                    int selectedId = binding.radioButton.getCheckedRadioButtonId();

                    if (selectedId != -1) {
                        // find the radiobutton by returned id
                        RadioButton radioButton = binding.radioButton.findViewById(selectedId);
                        readingViewModel.getReadingAnswerLiveData().getValue().forEach(readingAnswer -> {
                            if(radioButton.getText().toString().equals(readingAnswer.getAnswer()) && readingAnswer.isCorrect()) {
                                Log.d("reading", "dung");
                                score+=10;
                            }
                        });
                    }


                    showAnswer(i);
                    if (i == readingViewModel.getReadingQuestionsLiveDate().getValue().size()) {
                        binding.startButton.setText("Finish");
                    }
                }
                binding.radioButton.clearCheck();
            }
        });
    }

    private void showAnswer(int i) {
        readingViewModel.getReadingQuestionsLiveDate().observe(getViewLifecycleOwner(), new Observer<List<ReadingQuestion>>() {
            @Override
            public void onChanged(List<ReadingQuestion> readingQuestions) {
                readingViewModel.setReadingQuestion(readingQuestions.get(i));
                readingViewModel.getReadingAnswerByReadingQuestion(readingQuestions.get(i).getUuid());
                binding.itemLq1.setText(readingQuestions.get(i).getContent());
            }
        });
        readingViewModel.getReadingAnswerLiveData().observe(getViewLifecycleOwner(), new Observer<List<ReadingAnswer>>() {
            @Override
            public void onChanged(List<ReadingAnswer> readingAnswers) {
                binding.lqAnswer1.setText(readingAnswers.get(0).getAnswer());
                binding.lqAnswer2.setText(readingAnswers.get(1).getAnswer());
                binding.lqAnswer3.setText(readingAnswers.get(2).getAnswer());
                binding.lqAnswer4.setText(readingAnswers.get(3).getAnswer());
            }
        });
        this.i++;
    }
}