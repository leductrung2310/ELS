package com.example.els.view.home.listening;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.els.R;
import com.example.els.adapter.home.ListeningQuestionAdapter;
import com.example.els.databinding.FragmentLessonDetailBinding;
import com.example.els.databinding.FragmentListeningQuestionBinding;
import com.example.els.models.Api.ListeningQuestion;
import com.example.els.viewmodel.home.ListeningViewModel;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class ListeningQuestionFragment extends Fragment implements ListeningQuestionAdapter.ListeningQuestionInterface {

    private FragmentListeningQuestionBinding binding;
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private Handler handler = new Handler();

    private ListeningViewModel listeningViewModel;
    private ListeningQuestionAdapter listeningQuestionAdapter;
    private RecyclerView recyclerView;
    int i = 0;
    private ArrayList<String> answer = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
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

        binding.imagePlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    handler.removeCallbacks(updater);
                    mediaPlayer.pause();
                    binding.imagePlayPause.setImageResource(R.drawable.ic_listening_pause);
                } else {
                    mediaPlayer.start();
                    updateSeekBar();
                    binding.imagePlayPause.setImageResource(R.drawable.ic_listening_play);
                }
            }
        });
        preparedMediaPlayer();


        binding.playerSeekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        setUpObserver();

        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (i < listeningViewModel.getListeningQuestionLiveData().getValue().size()) {
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
                        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(getContext());
                        materialAlertDialogBuilder.setTitle("Do you want to finish the lesson");
                        materialAlertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                listeningViewModel.checkAnswer(answer);
                                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(getContext());
                                materialAlertDialogBuilder.setTitle("Lesson result");
                                materialAlertDialogBuilder.setMessage("Your score: " + String.valueOf(listeningViewModel.getScore().getValue()) + " points");
                                materialAlertDialogBuilder.setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        listeningViewModel.pushDoneLessonToFirestore();
                                        Navigation.findNavController(view).navigate(R.id.action_listeningQuestionFragment_to_skillsFragment);
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
                    i++;
                }
            }
        });

//        binding.viewPager2Employee.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
//                if (getItem(0) == 7) {
//                    binding.startButton.setText("Finish");
//                } else {
//                    binding.startButton.setText("Next");
//                }
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                super.onPageScrollStateChanged(state);
//
//            }
//        });
        showQuestion(0);
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(getContext());
                materialAlertDialogBuilder.setTitle("Do you want to exit the lesson?");
                materialAlertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Navigation.findNavController(view).navigate(R.id.action_listeningQuestionFragment_to_skillsFragment);
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
        });
    }

    private void setUpObserver() {
        final Observer<List<ListeningQuestion>> listeningQuestionObserver = listeningQuestions -> {
            listeningQuestionAdapter = new ListeningQuestionAdapter(getContext(), listeningQuestions, ListeningQuestionFragment.this);
            //binding.rcvListeningQuestion.setAdapter(listeningQuestionAdapter);
            //binding.rcvListeningQuestion.setAdapter(listeningQuestionAdapter);
        };

        listeningViewModel.getListeningQuestionLiveData().observe(getViewLifecycleOwner(), listeningQuestionObserver);
    }

    private Runnable updater = new Runnable() {
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
        } else {
            binding.imagePlayPause.setEnabled(false);
        }
    }

    private String milliSecondsToTimer(long milliSeconds) {
        String timerString = "";
        String secondsString;
        int hours = (int) (milliSeconds / (1000 * 60 * 60));
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
        listeningViewModel.getListeningQuestionLiveData().observe(getViewLifecycleOwner(), new Observer<List<ListeningQuestion>>() {
            @Override
            public void onChanged(List<ListeningQuestion> listeningQuestions) {
                binding.itemLq1.setText(listeningQuestions.get(a).getContent());
                int answerIndex = getRandomNumber(1, 4);
                getAnswer(answerIndex, listeningViewModel.getListeningQuestionLiveData().getValue().get(a));
                i++;
            }
        });
        //binding.itemLq1.setText(listeningViewModel.getListeningQuestionLiveData().getValue().get(i).getContent());
    }

//    private int getItem(int i) {
//        Log.d("listening 2", String.valueOf(binding.viewPager2Employee.getCurrentItem()));
//        return binding.viewPager2Employee.getCurrentItem() + i;
//    }

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
        String answer_term = "";
        int random;
        Random rand = new Random();
        for (int i = 1; i <= 4; i++) {
            do {
                do {
                    random = rand.nextInt(listeningViewModel.getListeningQuestionLiveData().getValue().size());
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
            } while (listeningViewModel.getListeningQuestionLiveData().getValue().get(random).getUuid() == listeningQuestion.getUuid());
        }
    }

    @Override
    public void onPause() {
        mediaPlayer.pause();
        super.onPause();
    }
}