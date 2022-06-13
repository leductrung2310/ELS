package com.example.els.network.reading;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.els.models.Api.Listening;
import com.example.els.models.Api.ListeningFirebase;
import com.example.els.models.Api.ListeningQuestion;
import com.example.els.models.Api.ReadingAnswer;
import com.example.els.models.Api.ReadingFirebase;
import com.example.els.models.Api.ReadingLesson;
import com.example.els.models.Api.ReadingQuestion;
import com.example.els.network.ApiUtils;
import com.example.els.network.listening.ListeningRepository;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReadingRepository {
    private final ReadingApi readingApi = ApiUtils.getReading();

    public void getAllReadingLesson(GetAllReadingLesson getAllReadingLesson) {
        readingApi.getAllReadingLesson().enqueue(new Callback<List<ReadingLesson>>() {
            @Override
            public void onResponse(Call<List<ReadingLesson>> call, Response<List<ReadingLesson>> response) {
                if (response.isSuccessful() & response.body() != null) {
                    Log.d("reading lesson", "có data trả về body");
                    getAllReadingLesson.onCallBackResponse((ArrayList<ReadingLesson>) response.body());
                } else {
                    Log.d("reading lesson", "ko có body");
                }
            }

            @Override
            public void onFailure(Call<List<ReadingLesson>> call, Throwable t) {
                Log.d("reading lesson", "onFailure " + t.getMessage());
                getAllReadingLesson.onCallBackFailure(new ArrayList<>());
            }
        });
    }

    public void getDoneReadingLessonFromFirestore(GetDoneListeningFromFirestore getDoneListeningFromFirestore) {
        CollectionReference collectionReference =
                FirebaseFirestore
                        .getInstance()
                        .collection("ELSUser")
                        .document(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                        .collection("reading");
        collectionReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    ArrayList<ReadingFirebase> readingFirebases = new ArrayList<>();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        readingFirebases.add(
                                new ReadingFirebase(
                                        document.getString("id"),
                                        document.getString("score"),
                                        (ArrayList) document.get("answer")
                                ));
                    }
                    getDoneListeningFromFirestore.onCallBackResponse(readingFirebases);
                } else {
                    getDoneListeningFromFirestore.onCallBackFailure(new ArrayList<>());
                }
            }
        });
    }

    public void getReadingQuestionByReadingLesson(String id, GetReadingQuestionByReadingLesson getReadingQuestionByReadingLesson) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        readingApi.getReadingQuestionByReadingLesson(params).enqueue(new Callback<List<ReadingQuestion>>() {
            @Override
            public void onResponse(Call<List<ReadingQuestion>> call, Response<List<ReadingQuestion>> response) {
                if (response.isSuccessful() & response.body() != null) {
                    Log.d("reading question", "có data trả về body");
                    getReadingQuestionByReadingLesson.onCallBackResponse((ArrayList<ReadingQuestion>) response.body());
                } else {
                    Log.d("reading question", "ko có body");
                }
            }

            @Override
            public void onFailure(Call<List<ReadingQuestion>> call, Throwable t) {
                getReadingQuestionByReadingLesson.onCallBackFailure(new ArrayList<>());
            }
        });
    }

    public void getReadingAnswerByReadingQuestion(String id, GetReadingAnswerByReadingQuestion getReadingAnswerByReadingQuestion) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        readingApi.getReadingAnswerByReadingQuestion(params).enqueue(new Callback<List<ReadingAnswer>>() {
            @Override
            public void onResponse(Call<List<ReadingAnswer>> call, Response<List<ReadingAnswer>> response) {
                if (response.isSuccessful() & response.body() != null) {
                    Log.d("reading answer", "có data trả về body");
                    getReadingAnswerByReadingQuestion.onCallBackResponse((ArrayList<ReadingAnswer>) response.body());
                } else {
                    Log.d("reading answer", "ko có body");
                }
            }

            @Override
            public void onFailure(Call<List<ReadingAnswer>> call, Throwable t) {
                getReadingAnswerByReadingQuestion.onCallBackFailure(new ArrayList<>());
            }
        });
    }

    public void pushDoneReadingLessonFromFirestore(ReadingFirebase readingFirebase) {
        CollectionReference collectionReference =
                FirebaseFirestore
                        .getInstance()
                        .collection("ELSUser")
                        .document(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                        .collection("reading");
        collectionReference.document().set(readingFirebase).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d("reading firebase", "oke task");
                }
            }
        });
    }

    public void getCorrectReadingAnswerByReadingQuestion(String id, GetReadingAnswerByReadingQuestion getReadingAnswerByReadingQuestion) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        readingApi.getCorrectReadingAnswerByReadingQuestion(params).enqueue(new Callback<List<ReadingAnswer>>() {
            @Override
            public void onResponse(Call<List<ReadingAnswer>> call, Response<List<ReadingAnswer>> response) {
                if (response.isSuccessful() & response.body() != null) {
                    Log.d("reading answer", "có data trả về body");
                    getReadingAnswerByReadingQuestion.onCallBackResponse((ArrayList<ReadingAnswer>) response.body());
                } else {
                    Log.d("reading answer", "ko có body");
                }
            }

            @Override
            public void onFailure(Call<List<ReadingAnswer>> call, Throwable t) {
                getReadingAnswerByReadingQuestion.onCallBackFailure(new ArrayList<>());
            }
        });
    }

    public interface GetReadingAnswerByReadingQuestion {
        void onCallBackResponse(ArrayList<ReadingAnswer> readingLessons);

        void onCallBackFailure(ArrayList<ReadingAnswer> readingLessons);
    }

    public interface GetReadingQuestionByReadingLesson {
        void onCallBackResponse(ArrayList<ReadingQuestion> readingLessons);

        void onCallBackFailure(ArrayList<ReadingQuestion> readingLessons);
    }

    public interface GetDoneListeningFromFirestore {
        void onCallBackResponse(ArrayList<ReadingFirebase> readingFirebases);

        void onCallBackFailure(ArrayList<ReadingFirebase> readingFirebases);
    }

    public interface GetAllReadingLesson {
        void onCallBackResponse(ArrayList<ReadingLesson> readingLessons);

        void onCallBackFailure(ArrayList<ReadingLesson> readingLessons);
    }
}
