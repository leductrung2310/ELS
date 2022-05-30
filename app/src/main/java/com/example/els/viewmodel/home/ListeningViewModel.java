package com.example.els.viewmodel.home;

import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.els.models.Api.Listening;
import com.example.els.models.Api.ListeningFirebase;
import com.example.els.models.Api.ListeningQuestion;
import com.example.els.models.Lesson;
import com.example.els.models.LessonData;
import com.example.els.network.listening.ListeningRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListeningViewModel extends ViewModel {
    private final LessonData lessonData = new LessonData();

    // Done listening lessons
    private MutableLiveData<ArrayList<Lesson>> _doneListeningLessons;

    public LiveData<ArrayList<Lesson>> getDoneListeningLessons() {
        if (_doneListeningLessons == null) _doneListeningLessons = new MutableLiveData<>();
        loadDoneLessons();
        return _doneListeningLessons;
    }

    public void loadDoneLessons() {
        ArrayList<Lesson> temp = new ArrayList<>();
        for (int i = 0; i < lessonData.listeningLessons.size(); i++) {
            if (lessonData.listeningLessons.get(i).getState()) {
                temp.add(lessonData.listeningLessons.get(i));
            }
        }
        _doneListeningLessons.setValue(temp);
    }

    // Undone listening lessons
    private MutableLiveData<ArrayList<Lesson>> _undoneListeningLessons;

    public LiveData<ArrayList<Lesson>> getUndoneListeningLessons() {
        if (_undoneListeningLessons == null) _undoneListeningLessons = new MutableLiveData<>();
        loadUndoneLessons();
        return _undoneListeningLessons;
    }

    public void loadUndoneLessons() {
        ArrayList<Lesson> temp = new ArrayList<>();
        for (int i = 0; i < lessonData.listeningLessons.size(); i++) {
            if (!lessonData.listeningLessons.get(i).getState()) {
                temp.add(lessonData.listeningLessons.get(i));
            }
        }
        _undoneListeningLessons.setValue(temp);
    }

    // Total duration
    private final MutableLiveData<Integer> _totalDuration = new MutableLiveData<>(0);

    public LiveData<Integer> getTotalDuration() {
        int total = 0;
        for (int i = 0; i < lessonData.listeningLessons.size(); i++) {
            total += lessonData.listeningLessons.get(i).getDuration();
        }
        _totalDuration.setValue(total);
        return _totalDuration;
    }

    // Number of lessons
    private final MutableLiveData<Integer> _totalLessons = new MutableLiveData<>(0);

    public LiveData<Integer> getTotalLessons() {
        _totalLessons.setValue(lessonData.listeningLessons.size());
        return _totalLessons;
    }

    // Complete percentage
    private final MutableLiveData<Integer> _completePercentage = new MutableLiveData<>(0);

    public LiveData<Integer> getCompletePercentage() {
        int count = 0;
        for (int i = 0; i < lessonData.listeningLessons.size(); i++) {
            if (lessonData.listeningLessons.get(i).getState()) {
                count++;
            }
        }
        double percentage = ((double) count / (double) lessonData.listeningLessons.size() * 100);
        int percent = (int) percentage;
        _completePercentage.setValue(percent);
        return _completePercentage;
    }

    private ListeningRepository listeningRepository;
    private MutableLiveData<List<Listening>> listeningLiveData;
    private MutableLiveData<List<ListeningQuestion>> listeningQuestionLiveData;
    private MutableLiveData<String> title;
    private MutableLiveData<String> content;
    private int position;
    private Listening listening;
    private MutableLiveData<MediaPlayer> mediaPlayer;
    private Handler handler;
    private MutableLiveData<ArrayList<Listening>> unDoneListening;
    private MutableLiveData<ArrayList<Listening>> doneListening;
    private MutableLiveData<ArrayList<ListeningFirebase>> doneListeningFirebase;

    public ListeningViewModel() {
        listeningRepository = new ListeningRepository();
        listeningLiveData = new MutableLiveData<>();
        listeningQuestionLiveData = new MutableLiveData<>();
        unDoneListening = new MutableLiveData<>();
        doneListening = new MutableLiveData<>();
        doneListeningFirebase = new MutableLiveData<>();

        title = new MutableLiveData<>();
        content = new MutableLiveData<>();
        mediaPlayer = new MutableLiveData<>();
        handler = new Handler();

    }


    public void getDataListeningLesson() {
        listeningRepository.getAllListeningLesson(new ListeningRepository.OnGetSurveyListener() {
            @Override
            public void onCallBack(ArrayList<Listening> data) {
                Log.d("listening", "có data lesson");
                listeningLiveData.setValue(data);
                getDoneListeningFromFireStore();
            }

            @Override
            public void onCallBackFailure(ArrayList<Listening> listenings) {
                Log.d("listening", "nothing here");
                listeningLiveData.setValue(listenings);
            }
        });
    }

    public void getDataListeningQuestionByLesson(String id) {
        Log.d("listening", "vô đây x");
        listeningQuestionLiveData.setValue(new ArrayList<>());
        listeningRepository.getListeningQuestionByLesson(id, data -> {
            listeningQuestionLiveData.setValue(data);
        });
    }

    public void getDoneListeningFromFireStore() {
        Log.d("listening", "vô đây x");
        listeningRepository.getDoneListeningFromFirestore(new ListeningRepository.ListeningFromFirestore() {
            @Override
            public void onGetDoneListening(ArrayList<ListeningFirebase> listeningQuestions) {
                doneListeningFirebase.setValue(listeningQuestions);
                Log.d("listening", "vô đây xx");
                setUnDoneListeningFromFirebase(Objects.requireNonNull(listeningQuestions));
            }
        });
    }

    public void setUnDoneListeningFromFirebase(ArrayList<ListeningFirebase> listeningQuestions) {
        if (listeningQuestions.size() == Objects.requireNonNull(listeningLiveData.getValue()).size()) {
            doneListening.setValue((ArrayList<Listening>) listeningLiveData.getValue());
            unDoneListening.setValue(new ArrayList<>());
        } else if (listeningQuestions.size() == 0) {
            unDoneListening.setValue((ArrayList<Listening>) listeningLiveData.getValue());
            doneListening.setValue(new ArrayList<>());
        } else {
            for (int i = 0; i < listeningQuestions.size(); i++) {
                for (int j = 0; j < Objects.requireNonNull(listeningLiveData.getValue()).size(); j++) {
                    if (!Objects.equals(listeningLiveData.getValue().get(i).getUuid(), listeningQuestions.get(j).getId())) {
                        Objects.requireNonNull(unDoneListening.getValue()).add(listeningLiveData.getValue().get(i));
                    } else {
                        Objects.requireNonNull(doneListening.getValue()).add(listeningLiveData.getValue().get(i));
                    }
                }
            }
        }
    }

    public MutableLiveData<MediaPlayer> getMediaPlayer() {
        return this.mediaPlayer;
    }

    public void setMediaPlayer(MutableLiveData<MediaPlayer> mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public LiveData<List<Listening>> getListeningLiveData() {
        return this.listeningLiveData;
    }

    public LiveData<List<ListeningQuestion>> getListeningQuestionLiveData() {
        return this.listeningQuestionLiveData;
    }

    public MutableLiveData<String> getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title.setValue(title);
    }

    public MutableLiveData<String> getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content.setValue(content);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Listening getListening() {
        return listening;
    }

    public void setListening(Listening listening) {
        this.listening = listening;
    }


    public MutableLiveData<ArrayList<Listening>> getUnDoneListening() {
        return unDoneListening;
    }

    public void setUnDoneListening(ArrayList<Listening> unDoneListening) {
        this.unDoneListening.setValue(unDoneListening);
    }

    public MutableLiveData<ArrayList<Listening>> getDoneListening() {
        return doneListening;
    }

    public void setDoneListening(ArrayList<Listening> doneListening) {
        this.doneListening.setValue(doneListening);
    }

    public MutableLiveData<ArrayList<ListeningFirebase>> getDoneListeningFirebase() {
        return doneListeningFirebase;
    }

    public void setDoneListeningFirebase(ArrayList<ListeningFirebase> doneListeningFirebase) {
        this.doneListeningFirebase.setValue(doneListeningFirebase);
    }
}
