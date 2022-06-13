package com.example.els.view.home.reading;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.els.R;
import com.example.els.databinding.FragmentReadingQuestionBinding;
import com.example.els.viewmodel.home.ReadingViewModel;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.Objects;

public class ReadingQuestionFragment extends Fragment {
    private FragmentReadingQuestionBinding binding;
    private ReadingViewModel readingViewModel;
    int i = 0;
    int score = 0;
    private final ArrayList<String> answer = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentReadingQuestionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        readingViewModel = new ViewModelProvider(requireActivity()).get(ReadingViewModel.class);

        binding.backBtn.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.action_readingQuestionFragment_to_skillsFragment));
        showAnswer(i);

        binding.startButton.setOnClickListener(view12 -> {
            if (binding.startButton.getText() == "Finish") {
                int selectedId = binding.radioButton.getCheckedRadioButtonId();

                if (selectedId != -1) {
                    // find the radiobutton by returned id
                    RadioButton radioButton = binding.radioButton.findViewById(selectedId);
                    answer.add(radioButton.getText().toString());
                    Objects.requireNonNull(readingViewModel.getReadingAnswerLiveData().getValue()).forEach(readingAnswer -> {
                        if(radioButton.getText().toString().equals(readingAnswer.getAnswer()) && readingAnswer.isCorrect()) {
                            score+=10;
                        }
                    });
                } else {
                    answer.add("answer");
                }
                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(requireContext());
                materialAlertDialogBuilder.setTitle("Do you want to finish the lesson");
                materialAlertDialogBuilder.setPositiveButton("Yes", (dialogInterface, i) -> {
                    MaterialAlertDialogBuilder materialAlertDialogBuilder1 = new MaterialAlertDialogBuilder(requireContext());
                    materialAlertDialogBuilder1.setTitle("Lesson result");
                    materialAlertDialogBuilder1.setMessage("Your score: " + score+ " points");
                    materialAlertDialogBuilder1.setPositiveButton("Oke", (dialogInterface1, i1) -> {
                        readingViewModel.pushDoneReadingLessonToFirestore(score, answer);
                        Navigation.findNavController(view12).navigate(R.id.action_readingQuestionFragment_to_skillsFragment);
                    });
                    materialAlertDialogBuilder1.show();
                });
                materialAlertDialogBuilder.setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel());
                materialAlertDialogBuilder.show();
            }
            if ( i < Objects.requireNonNull(readingViewModel.getReadingQuestionsLiveDate().getValue()).size()) {
                int selectedId = binding.radioButton.getCheckedRadioButtonId();

                if (selectedId != -1) {
                    // find the radiobutton by returned id
                    RadioButton radioButton = binding.radioButton.findViewById(selectedId);
                    answer.add(radioButton.getText().toString());
                    Objects.requireNonNull(readingViewModel.getReadingAnswerLiveData().getValue()).forEach(readingAnswer -> {
                        if(radioButton.getText().toString().equals(readingAnswer.getAnswer()) && readingAnswer.isCorrect()) {
                            Log.d("reading", "dung");
                            score+=10;
                        }
                    });
                } else {
                    answer.add("answer");
                }


                showAnswer(i);
                if (i == readingViewModel.getReadingQuestionsLiveDate().getValue().size()) {
                    binding.startButton.setText("Finish");
                }
            }
            binding.radioButton.clearCheck();
        });
    }

    private void showAnswer(int i) {
        readingViewModel.getReadingQuestionsLiveDate().observe(getViewLifecycleOwner(), readingQuestions -> {
            readingViewModel.setReadingQuestion(readingQuestions.get(i));
            readingViewModel.getReadingAnswerByReadingQuestion(readingQuestions.get(i).getUuid());
            binding.itemLq1.setText(readingQuestions.get(i).getContent());
        });
        readingViewModel.getReadingAnswerLiveData().observe(getViewLifecycleOwner(), readingAnswers -> {
            binding.lqAnswer1.setText(readingAnswers.get(0).getAnswer());
            binding.lqAnswer2.setText(readingAnswers.get(1).getAnswer());
            binding.lqAnswer3.setText(readingAnswers.get(2).getAnswer());
            binding.lqAnswer4.setText(readingAnswers.get(3).getAnswer());
        });
        this.i++;
    }
}