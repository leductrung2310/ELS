package com.example.els.viewmodel.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.els.models.Api.Listening;
import com.example.els.models.Api.ListeningFirebase;
import com.example.els.models.Api.ListeningQuestion;
import com.example.els.network.listening.ListeningRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ListeningViewModel extends ViewModel {
    private final ListeningRepository listeningRepository;
    private final MutableLiveData<List<Listening>> listeningLiveData;
    private final MutableLiveData<List<ListeningQuestion>> listeningQuestionLiveData;
    private final MutableLiveData<String> title;
    private final MutableLiveData<String> content;
    private final MutableLiveData<String> image;
    private int position;
    private Listening listening;
    private final MutableLiveData<ArrayList<Listening>> unDoneListening;
    private final MutableLiveData<ArrayList<Listening>> doneListening;
    private final MutableLiveData<ArrayList<ListeningFirebase>> doneListeningFirebase;
    private final HashMap<Integer, String>  answerMap;
    private MutableLiveData<Integer>  score;

    public ListeningViewModel() {
        listeningRepository = new ListeningRepository();
        listeningLiveData = new MutableLiveData<>();
        listeningQuestionLiveData = new MutableLiveData<>();
        unDoneListening = new MutableLiveData<>();
        doneListening = new MutableLiveData<>();
        doneListeningFirebase = new MutableLiveData<>();

        title = new MutableLiveData<>();
        content = new MutableLiveData<>();
        image = new MutableLiveData<>();

        answerMap = new HashMap<>();
        score = new MutableLiveData<>();
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
        listeningRepository.getListeningQuestionByLesson(id, listeningQuestionLiveData::setValue);
    }

    public void getDoneListeningFromFireStore() {
        Log.d("listening", "vô đây x");
        listeningRepository.getDoneListeningFromFirestore(listeningQuestions -> {
            doneListeningFirebase.setValue(listeningQuestions);
            Log.d("listening", "vô đây xx");
            setUnDoneListeningFromFirebase(Objects.requireNonNull(listeningQuestions));
        });
    }

    public void setUnDoneListeningFromFirebase(ArrayList<ListeningFirebase> listeningQuestions) {
        ArrayList<Listening> _done = new ArrayList<>();
        if (listeningQuestions.size() == Objects.requireNonNull(listeningLiveData.getValue()).size()) {
            doneListening.setValue((ArrayList<Listening>) listeningLiveData.getValue());
            unDoneListening.setValue(new ArrayList<>());
        } else if (listeningQuestions.size() == 0) {
            unDoneListening.setValue((ArrayList<Listening>) listeningLiveData.getValue());
            doneListening.setValue(new ArrayList<>());
        } else {
            for (int i = 0; i < Objects.requireNonNull(listeningLiveData.getValue()).size(); i++) {
                for (int j = 0; j < listeningQuestions.size(); j++) {
                    if (!Objects.equals(listeningLiveData.getValue().get(i).getUuid(), listeningQuestions.get(j).getId())) {
//                        Log.d("listening", "add u  ndone");
//                        _unDone.add(listeningLiveData.getValue().get(i));
                    } else {
                        Log.d("listening", "add done");
                        _done.add(listeningLiveData.getValue().get(i));
                    }
                }
            }
            doneListening.setValue(_done);
            ArrayList<Listening> _unDone = new ArrayList<>(listeningLiveData.getValue());
            _unDone.removeAll(_done);
            unDoneListening.setValue(_unDone);
            Log.d("listening", String.valueOf(Objects.requireNonNull(doneListening.getValue()).size()));
            Log.d("listening", String.valueOf(Objects.requireNonNull(unDoneListening.getValue()).size()));
        }
    }

    public void checkAnswer(ArrayList<String> answer) {
        Log.d("Listening", answer.toString());
        int _score = 0;
        for (int i = 0; i< Objects.requireNonNull(listeningQuestionLiveData.getValue()).size(); i++) {
          if (Objects.equals(listeningQuestionLiveData.getValue().get(i).getAnswer(), answer.get(i))) {
              _score += 10;
          }
        }
        score.setValue(_score);
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

    public MutableLiveData<String> getImage() {
        return image;
    }

    public void setImage(String content) {
        this.image.setValue(content);
    }

    public MutableLiveData<ArrayList<Listening>> getUnDoneListening() {
        return unDoneListening;
    }

    public MutableLiveData<ArrayList<Listening>> getDoneListening() {
        return doneListening;
    }

    public MutableLiveData<ArrayList<ListeningFirebase>> getDoneListeningFirebase() {
        return doneListeningFirebase;
    }

    public HashMap<Integer, String> getAnswerMap() {
        return answerMap;
    }

    public MutableLiveData<Integer> getScore() {
        return score;
    }

    public void setScore(MutableLiveData<Integer> score) {
        this.score = score;
    }


    //pushDoneLessonToFirestore
    public void pushDoneLessonToFirestore() {
        ListeningFirebase listeningFirebase = new ListeningFirebase(Objects.requireNonNull(unDoneListening.getValue()).get(position).getUuid(), Integer.toString(score.getValue()));
        listeningRepository.pushDoneListeningFromFirestore(listeningFirebase);
    }

}
