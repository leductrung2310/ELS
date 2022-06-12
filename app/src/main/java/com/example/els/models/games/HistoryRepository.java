package com.example.els.models.games;

import android.annotation.SuppressLint;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HistoryRepository {
    // Constant variables
    public static final String TAG = "HistoryFirestore";
    public static final String historyPath = "History";

    private final FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    private final FirebaseAuth auth = FirebaseAuth.getInstance();

    // fetch and return a list of history to check if it is exist
    public ArrayList<History> fetchHistory() {
        ArrayList<History> histories = new ArrayList<>();
        DocumentReference reference = firestore.collection(historyPath).document(Objects.requireNonNull(auth.getCurrentUser()).getUid());
        reference.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot documentSnapshot = task.getResult();
                if (documentSnapshot.exists()) {
                    histories.addAll(Objects.requireNonNull(documentSnapshot.toObject(HistoryDocument.class)).histories);
                }
            } else {
                Log.d(TAG, "Error getting documents: ", task.getException());
            }
        });

        // return will be run first than
        return histories;
    }

    // Get history list from the firestore
    public void getHistoryList(OnGettingListener listener) {
        ArrayList<History> histories = new ArrayList<>();
        DocumentReference reference = firestore.collection(historyPath).document(Objects.requireNonNull(auth.getCurrentUser()).getUid());
        reference.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot documentSnapshot = task.getResult();
                if (documentSnapshot.exists()) {
                    histories.addAll(Objects.requireNonNull(documentSnapshot.toObject(HistoryDocument.class)).histories);
                }
                listener.onGettingHistoryCallBack(histories);
            } else {
                Log.d(TAG, "Error getting documents: ", task.getException());
            }
        });
    }

    // This callback used with asynchronous programming
    public interface OnGettingListener {
        void onGettingHistoryCallBack(ArrayList<History> histories);
    }

    // push history to firestore every time user complete playing
    public void pushHistoryToFireStore(History history) {
        // Create an id that is made with a his and the new index
        Date date = new Date();

        ArrayList<History> histories = new ArrayList<>();
        histories.add(history);

        Map<String, Object> newHistory = new HashMap<>();
        newHistory.put("histories", histories);

        CollectionReference reference = firestore.collection(historyPath);
        String userId = Objects.requireNonNull(auth.getCurrentUser()).getUid();

        reference.document(userId).set(newHistory)
                .addOnSuccessListener(unused -> Log.d(TAG, "DocumentSnapshot successfully written!"))
                .addOnFailureListener(e -> Log.w(TAG, "Error writing document", e));
    }

    // update history to firestore every time user complete playing
    public void updateHistoryToFirestore(History history) {
        // Create an id that is made with a his and the new index
        Date date = new Date();
        @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
        String id = dateFormat.format(date);

        Map<String, Object> newHistory = new HashMap<>();
        newHistory.put("histories", FieldValue.arrayUnion(history));

        CollectionReference reference = firestore.collection(historyPath);
        String userId = Objects.requireNonNull(auth.getCurrentUser()).getUid();

        reference.document(userId).update(newHistory)
                .addOnSuccessListener(unused -> Log.d(TAG, "DocumentSnapshot successfully written!"))
                .addOnFailureListener(e -> Log.w(TAG, "Error writing document", e));
    }
}
