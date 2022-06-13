package com.example.els.viewmodel.authentication;

import android.app.Application;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.els.models.ELSUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SignUpViewmodel extends AndroidViewModel {

    private final Application application;
    private final MutableLiveData<Boolean> isRegisterSuccessLiveData;
    private final FirebaseAuth firebaseAuth;
    private final FirebaseFirestore firebaseFirestore;

    public SignUpViewmodel(@NonNull Application application) {
        super(application);
        this.application = application;
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.firebaseFirestore = FirebaseFirestore.getInstance();
        this.isRegisterSuccessLiveData = new MutableLiveData<>(false);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void register(String email, String password, ELSUser newUser) {
        try {
            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(application.getMainExecutor(), new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        isRegisterSuccessLiveData.postValue(true);
                        Toast.makeText(application.getApplicationContext(), "Register successfully", Toast.LENGTH_SHORT).show();
                        pushUserToFirestore(newUser);
                    } else {
                        Toast.makeText(application.getApplicationContext(), "Register Failure: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        } catch (Exception e) {
            Toast.makeText(application.getApplicationContext(), "Not Support The Remaining Android Version!", Toast.LENGTH_SHORT).show();
        }
    }

    public void pushUserToFirestore(ELSUser user) {

        Map<String, Object> newUser = new HashMap<>();
        newUser.put("name", user.getName());
        newUser.put("age", user.getAge());
        newUser.put("gender", user.isGender());
        newUser.put("position", user.getPosition());
        newUser.put("phoneNumber", user.getPhoneNumber());

        CollectionReference collection = firebaseFirestore.collection("ELSUser");
        String userId = firebaseAuth.getCurrentUser().getUid();

        collection.document(userId).set(newUser)
                .addOnSuccessListener(unused -> {
                })
                .addOnFailureListener(e -> {
                });
    }

    public MutableLiveData<Boolean> getIsRegisterSuccessLiveData() {
        return isRegisterSuccessLiveData;
    }
}
