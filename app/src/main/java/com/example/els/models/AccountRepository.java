package com.example.els.models;

import androidx.annotation.NonNull;

import com.example.els.models.authentication.GeneralUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class AccountRepository {

    private FirebaseFirestore db;
    private FirebaseAuth firebaseAuth;

    public AccountRepository() {
        this.db = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
    }

    int checkInt(String string) {
        if(string == null ) {
            return 0;
        }
        return Integer.parseInt(string);
    }

    String checkString(String string) {
        if(string.equals("") || string == null) {
            return "---";
        }
        return string;
    }

    Boolean checkBoolean(String string) {
        if(string == null) {
            return true;
        }
        return Boolean.valueOf(string);
    }


    public void getUserDataFromFirestore() {
        DocumentReference docRef = db.collection("ELSUser").document(firebaseAuth.getCurrentUser().getUid());
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        GeneralUser.getInstance().setUserName( checkString(document.getString("name")));
                        GeneralUser.getInstance().setAge(checkString(document.getString("age")));
                        GeneralUser.getInstance().setGender(checkString(document.getString("gender")));
                        GeneralUser.getInstance().setPosition(checkString(document.getString("position")));
                        GeneralUser.getInstance().setPhoneNumber(checkString(document.getString("phoneNumber")));
                    } else {
                    }
                } else {

                }
            }
        });
    }
}
