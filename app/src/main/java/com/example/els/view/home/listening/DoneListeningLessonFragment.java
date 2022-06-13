package com.example.els.view.home.listening;

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
import com.example.els.adapter.home.DoneListeningAdapter;
import com.example.els.databinding.FragmentDoneListeningLessonBinding;
import com.example.els.models.Api.Listening;
import com.example.els.models.Api.ListeningFirebase;
import com.example.els.viewmodel.home.ListeningViewModel;

import java.util.List;
import java.util.Objects;

public class DoneListeningLessonFragment extends Fragment {
    FragmentDoneListeningLessonBinding binding;
    private final MediaPlayer mediaPlayer = new MediaPlayer();
    private final Handler handler = new Handler();

    private ListeningViewModel listeningViewModel;
    private DoneListeningAdapter listeningQuestionAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDoneListeningLessonBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

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
        setUpObserver();
        preparedMediaPlayer();

        binding.backBtn.setOnClickListener(view12 -> Navigation.findNavController(view12).navigate(R.id.action_doneListeningLessonFragment_to_skillsFragment));
    }

    private void setUpObserver() {
        final Observer<List<Listening>> listObserver = data -> {
            listeningViewModel.getDataListeningQuestionByLesson(data.get(listeningViewModel.getPosition()).getUuid());
            listeningViewModel.setTitle(data.get(listeningViewModel.getPosition()).getTitle());
            listeningViewModel.setContent(data.get(listeningViewModel.getPosition()).getContent());
            listeningViewModel.setImage(data.get(listeningViewModel.getPosition()).getImage());
            listeningViewModel.setListening(data.get(listeningViewModel.getPosition()));
        };
        listeningViewModel.getDoneListening().observe(getViewLifecycleOwner(), listObserver);

        listeningViewModel.getListeningQuestionLiveData().observe(getViewLifecycleOwner(), listeningQuestions -> {
            if (!listeningQuestions.isEmpty()) {
                for (ListeningFirebase listeningFirebase:
                        Objects.requireNonNull(listeningViewModel.getDoneListeningFirebase().getValue())) {
                    if (listeningFirebase.getId().equals(listeningQuestions.get(0).getListeningUuid())) {
                        listeningQuestionAdapter = new DoneListeningAdapter(listeningQuestions, listeningFirebase);
                        binding.rcvListeningQuestion.setAdapter(listeningQuestionAdapter);
                    }
                }
            }
        });
        
        listeningViewModel.getDoneListeningFirebase().observe(getViewLifecycleOwner(), listeningFirebases -> {
            for (ListeningFirebase listeningFirebase: listeningFirebases) {
                String firstId =  listeningFirebase.getId();
                String secondId =  Objects.requireNonNull(listeningViewModel.getListeningLiveData().getValue()).get(listeningViewModel.getPosition()).getUuid();
               if (Objects.equals(firstId, secondId)) {
                   binding.score.setText(listeningFirebase.getScore());
               }
            }
        });
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
            mediaPlayer.setDataSource(Objects.requireNonNull(listeningViewModel.getListeningLiveData().getValue()).get(listeningViewModel.getPosition()).getAudio());
            mediaPlayer.prepare();
            binding.totalDuration.setText(milliSecondsToTimer(mediaPlayer.getDuration()));
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void updateSeekBar() {
        if (mediaPlayer.isPlaying()) {
            Log.d("Listening", String.valueOf(mediaPlayer.getCurrentPosition()));
            Log.d("Listening", String.valueOf(mediaPlayer.getDuration()));
            binding.playerSeekBar.setProgress((int) (((float) mediaPlayer.getCurrentPosition() / mediaPlayer.getDuration()) * 100));
            handler.postDelayed(updater, 1000);
        }
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

    @Override
    public void onPause() {
        mediaPlayer.pause();
        super.onPause();
    }
}