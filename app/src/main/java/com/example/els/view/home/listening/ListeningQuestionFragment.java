package com.example.els.view.home.listening;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.els.R;
import com.example.els.adapter.home.ListeningQuestionAdapter;
import com.example.els.databinding.FragmentListeningQuestionBinding;
import com.example.els.models.Api.ListeningQuestion;
import com.example.els.viewmodel.home.ListeningViewModel;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ListeningQuestionFragment extends Fragment implements ListeningQuestionAdapter.ListeningQuestionInterface {

    private FragmentListeningQuestionBinding binding;
    private final MediaPlayer mediaPlayer = new MediaPlayer();
    private final Handler handler = new Handler();

    private ListeningViewModel listeningViewModel;
    private ListeningQuestionAdapter listeningQuestionAdapter;
    int i = 0;
    private final ArrayList<String> answer = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListeningQuestionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listeningViewModel = new ViewModelProvider(requireActivity()).get(ListeningViewModel.class);
        binding.playerSeekBar.setMax(100);

        binding.imagePlayPause.setOnClickListener(view1 -> {
            if (mediaPlayer.isPlaying()) {
                handler.removeCallbacks(updater);
                mediaPlayer.pause();
                binding.imagePlayPause.setImageResource(R.drawable.ic_listening_play);
            } else {
                mediaPlayer.start();
                updateSeekBar();
                binding.imagePlayPause.setImageResource(R.drawable.ic_listening_pause);
            }
        });
        preparedMediaPlayer();


        binding.playerSeekBar.setOnTouchListener((view12, motionEvent) -> true);
        setUpObserver();

        binding.startButton.setOnClickListener(view13 -> {
            if (i < Objects.requireNonNull(listeningViewModel.getListeningQuestionLiveData().getValue()).size()) {
                if (i == (listeningViewModel.getListeningQuestionLiveData().getValue().size() - 1)) {
                    binding.startButton.setText("Finish");
                }
                if (binding.lqAnswer1.isChecked()) {
                    answer.add(binding.lqAnswer1.getText().toString());
                } else
                if (binding.lqAnswer2.isChecked()) {
                    answer.add(binding.lqAnswer2.getText().toString());
                } else
                if (binding.lqAnswer3.isChecked()) {
                    answer.add(binding.lqAnswer3.getText().toString());
                } else
                if (binding.lqAnswer4.isChecked()) {
                    answer.add(binding.lqAnswer4.getText().toString());
                }else  {
                    answer.add("answer");
                }
                binding.radioButton.clearCheck();
                showQuestion(i);

            } else {
                if (i == listeningViewModel.getListeningQuestionLiveData().getValue().size()) {
                    if (binding.lqAnswer1.isChecked()) {
                        answer.add(binding.lqAnswer1.getText().toString());
                    } else
                    if (binding.lqAnswer2.isChecked()) {
                        answer.add(binding.lqAnswer2.getText().toString());
                    } else
                    if (binding.lqAnswer3.isChecked()) {
                        answer.add(binding.lqAnswer3.getText().toString());
                    } else
                    if (binding.lqAnswer4.isChecked()) {
                        answer.add(binding.lqAnswer4.getText().toString());
                    } else {
                        answer.add("answer");
                    }
                    binding.lqAnswer1.setEnabled(false);
                    binding.lqAnswer2.setEnabled(false);
                    binding.lqAnswer3.setEnabled(false);
                    binding.lqAnswer4.setEnabled(false);
                    Log.d("listening", answer.toString());

                }
                if (binding.startButton.getText() == "Finish") {
                    MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(requireContext());
                    materialAlertDialogBuilder.setTitle("Do you want to finish the lesson");
                    materialAlertDialogBuilder.setPositiveButton("Yes", (dialogInterface, i) -> {
                        listeningViewModel.checkAnswer(answer);
                        MaterialAlertDialogBuilder materialAlertDialogBuilder1 = new MaterialAlertDialogBuilder(requireContext());
                        materialAlertDialogBuilder1.setTitle("Lesson result");
                        materialAlertDialogBuilder1.setMessage("Your score: " + listeningViewModel.getScore().getValue() + " points");
                        materialAlertDialogBuilder1.setPositiveButton("Oke", (dialogInterface1, i1) -> {
                            listeningViewModel.pushDoneLessonToFirestore(answer);
                            Navigation.findNavController(view13).navigate(R.id.action_listeningQuestionFragment_to_skillsFragment);
                        });
                        materialAlertDialogBuilder1.show();
                    });
                    materialAlertDialogBuilder.setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel());
                    materialAlertDialogBuilder.show();
                }
                i++;
            }
        });

        showQuestion(0);
        binding.backBtn.setOnClickListener(view14 -> {
            MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(requireContext());
            materialAlertDialogBuilder.setTitle("Do you want to exit the lesson?");
            materialAlertDialogBuilder.setPositiveButton("Yes", (dialogInterface, i) -> Navigation.findNavController(view14).navigate(R.id.action_listeningQuestionFragment_to_skillsFragment));
            materialAlertDialogBuilder.setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel());
            materialAlertDialogBuilder.show();
        });
    }

    private void setUpObserver() {
        final Observer<List<ListeningQuestion>> listeningQuestionObserver = listeningQuestions -> listeningQuestionAdapter = new ListeningQuestionAdapter(getContext(), listeningQuestions, ListeningQuestionFragment.this);

        listeningViewModel.getListeningQuestionLiveData().observe(getViewLifecycleOwner(), listeningQuestionObserver);
    }

    private final Runnable updater = new Runnable() {
        @Override
        public void run() {
            updateSeekBar();
            long currentDuration = mediaPlayer.getCurrentPosition();
            binding.currentTime.setText(milliSecondsToTimer(currentDuration));
        }
    };


    private void preparedMediaPlayer() {
        try {
            mediaPlayer.setDataSource(listeningViewModel.getListening().getAudio());
            mediaPlayer.prepare();
            binding.totalDuration.setText(milliSecondsToTimer(mediaPlayer.getDuration()));
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void updateSeekBar() {
        if (mediaPlayer.isPlaying()) {
            Log.d("Listening", String.valueOf(mediaPlayer.getCurrentPosition()));
            Log.d("Listening", String.valueOf(mediaPlayer.getDuration()));
            binding.playerSeekBar.setProgress((int) (((float) mediaPlayer.getCurrentPosition() / mediaPlayer.getDuration()) * 100));
            handler.postDelayed(updater, 1000);
        } else binding.imagePlayPause.setEnabled(false);
    }

    private String milliSecondsToTimer(long milliSeconds) {
        String timerString = "";
        String secondsString;
        int minutes = (int) (milliSeconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) ((milliSeconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);

        if (seconds < 10) {
            secondsString = "0" + seconds;
        } else {
            secondsString = "" + seconds;
        }

        timerString = timerString + minutes + ":" + secondsString;
        return timerString;
    }

    public void showQuestion(int a) {
        listeningViewModel.getListeningQuestionLiveData().observe(getViewLifecycleOwner(), listeningQuestions -> {
            binding.itemLq1.setText(listeningQuestions.get(a).getContent());
            int answerIndex = getRandomNumber(1, 4);
            getAnswer(answerIndex, Objects.requireNonNull(listeningViewModel.getListeningQuestionLiveData().getValue()).get(a));
            i++;
        });
    }


    @Override
    public void getAnswer(int position, String answer) {
        listeningViewModel.getAnswerMap().put(position, answer);
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void getAnswer(int answerIndex, ListeningQuestion listeningQuestion) {
        switch (answerIndex) {
            case 1:
                binding.lqAnswer1.setText(listeningQuestion.getAnswer());
                randomRestOfAnswer(listeningQuestion, answerIndex);
                break;
            case 2:
                binding.lqAnswer2.setText(listeningQuestion.getAnswer());
                randomRestOfAnswer(listeningQuestion, answerIndex);
                break;
            case 3:
                binding.lqAnswer3.setText(listeningQuestion.getAnswer());
                randomRestOfAnswer(listeningQuestion, answerIndex);
                break;
            case 4:
                binding.lqAnswer4.setText(listeningQuestion.getAnswer());
                randomRestOfAnswer(listeningQuestion, answerIndex);
                break;
        }
    }

    public void randomRestOfAnswer(ListeningQuestion listeningQuestion, int answerIndex) {
        String answer = "";
        String answer_term;
        int random;
        Random rand = new Random();
        for (int i = 1; i <= 4; i++) {
            do {
                do {
                    random = rand.nextInt(Objects.requireNonNull(listeningViewModel.getListeningQuestionLiveData().getValue()).size());
                    answer_term = answer;
                    answer = listeningViewModel.getListeningQuestionLiveData().getValue().get(random).getAnswer();
                } while (Objects.equals(answer_term, answer));
                if (i != answerIndex) {
                    switch (i) {
                        case 1:
                            binding.lqAnswer1.setText(answer);
                            break;
                        case 2:
                            binding.lqAnswer2.setText(answer);
                            break;
                        case 3:
                            binding.lqAnswer3.setText(answer);
                            break;
                        case 4:
                            binding.lqAnswer4.setText(answer);
                            break;
                    }
                }
            } while (Objects.equals(listeningViewModel.getListeningQuestionLiveData().getValue().get(random).getUuid(), listeningQuestion.getUuid()));
        }
    }

    @Override
    public void onPause() {
        mediaPlayer.pause();
        super.onPause();
    }
}