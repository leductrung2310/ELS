package com.example.els.network.listening;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.els.models.Api.Listening;
import com.example.els.models.Api.ListeningFirebase;
import com.example.els.models.Api.ListeningQuestion;
import com.example.els.network.ApiUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
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

public class ListeningRepository {
    private final ListeningApi listeningApi = ApiUtils.getAllListeningLesson();

    public void getAllListeningLesson(OnGetSurveyListener onGetSurveyListener) {
        Log.d("listening", "vô repo get data");
        listeningApi.getAllListeningLesson().enqueue(new Callback<List<Listening>>() {
            @Override
            public void onResponse(@NonNull Call<List<Listening>> call, @NonNull Response<List<Listening>> response) {
                if (response.isSuccessful() & response.body() != null) {
                    Log.d("listening", "có data trả về body");
                    onGetSurveyListener.onCallBack((ArrayList<Listening>) response.body());
                } else {
                    Log.d("listening", "ko có body");
                    Log.d("phat", "error");
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Listening>> call, @NonNull Throwable t) {
                onGetSurveyListener.onCallBackFailure(new ArrayList<>());
            }

        });
    }

    public interface OnGetSurveyListener {
        void onCallBack(ArrayList<Listening> listenings);

        void onCallBackFailure(ArrayList<Listening> listenings);
    }

    public void getListeningQuestionByLesson(String id, OnGetListeningQuestionByLesson onGetListeningQuestionByLesson) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        listeningApi.getAllListeningQuestion(params).enqueue(new Callback<List<ListeningQuestion>>() {
            @Override
            public void onResponse(Call<List<ListeningQuestion>> call, Response<List<ListeningQuestion>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    onGetListeningQuestionByLesson.onCallBack((ArrayList<ListeningQuestion>) response.body());
                } else {
                    Log.d("phat", "error");
                }
            }

            @Override
            public void onFailure(Call<List<ListeningQuestion>> call, Throwable t) {

            }
        });
    }

    public interface OnGetListeningQuestionByLesson {
        void onCallBack(ArrayList<ListeningQuestion> listeningQuestions);
        //void onGetSurveyFailure(errorMessage: String)
    }

    public interface ListeningFromFirestore {
        void onGetDoneListening(ArrayList<ListeningFirebase> listeningQuestions);
    }

    public void getDoneListeningFromFirestore(ListeningFromFirestore listeningFromFirestore) {
        CollectionReference collectionReference =
                FirebaseFirestore
                        .getInstance()
                        .collection("ELSUser")
                        .document(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                        .collection("listening");
        collectionReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    ArrayList<ListeningFirebase> listeningFirebases = new ArrayList<>();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        listeningFirebases.add(new ListeningFirebase(document.getId(), document.getString("score")));
                    }
                    listeningFromFirestore.onGetDoneListening(listeningFirebases);
                }
            }
        });
    }
}
