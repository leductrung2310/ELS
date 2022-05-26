package com.example.els.view.home.listening;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.List;

public class ListeningQuestionFragment extends Fragment {

    private FragmentListeningQuestionBinding binding;
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private Handler handler = new Handler();

    private ListeningViewModel listeningViewModel;
    private ListeningQuestionAdapter listeningQuestionAdapter;
    private RecyclerView recyclerView;

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

//        recyclerView = binding.rcvListeningQuestion;
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        setUpObserver();

        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getItem(0) <= 1)
                    binding.viewPager2Employee.setCurrentItem(getItem(1), true);
            }
        });
    }

    private void setUpObserver() {
        final Observer<List<ListeningQuestion>> listeningQuestionObserver = listeningQuestions -> {
            Log.d("listening", "vô đây");
            listeningQuestionAdapter = new ListeningQuestionAdapter(getContext(), listeningQuestions);
            //binding.rcvListeningQuestion.setAdapter(listeningQuestionAdapter);
            binding.viewPager2Employee.setAdapter(listeningQuestionAdapter);
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
        } catch (Exception e){
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void updateSeekBar() {
        if (mediaPlayer.isPlaying()) {
            Log.d("Listening",String.valueOf(mediaPlayer.getCurrentPosition()));
            Log.d("Listening",String.valueOf(mediaPlayer.getDuration()));
            binding.playerSeekBar.setProgress((int) (((float) mediaPlayer.getCurrentPosition()/ mediaPlayer.getDuration()) * 100 ) );
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

        if(seconds<10) {
            secondsString = "0" + seconds;
        } else {
            secondsString = "" + seconds;
        }

        timerString = timerString + minutes + ":" +secondsString;
        return timerString;
    }

    private int getItem(int i) {
        return binding.viewPager2Employee.getCurrentItem() + i;
    }
}