package com.example.els.viewmodel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.els.models.authentication.GeneralUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class PersonalViewmodel extends ViewModel {

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    MutableLiveData<Boolean> isEditNameSuccess;
    MutableLiveData<Boolean> isEditGenderSuccess;

    public PersonalViewmodel() {
        firebaseAuth = FirebaseAuth.getInstance();
        this.firebaseFirestore = FirebaseFirestore.getInstance();
        isEditNameSuccess = new MutableLiveData<>(false);
        isEditGenderSuccess = new MutableLiveData<>(false);
    }

    public void editUserName(String newName, Application application) {

        CollectionReference collection = firebaseFirestore.collection("ELSUser");
        String userId = firebaseAuth.getCurrentUser().getUid();

        collection.document(userId).update("name", newName )
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        isEditNameSuccess.setValue(true);
                        GeneralUser.getInstance().setUserName(newName);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(application.getApplicationContext(), "Edit Name Failed!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void editGender(String newGender, Application application) {

        CollectionReference collection = firebaseFirestore.collection("ELSUser");
        String userId = firebaseAuth.getCurrentUser().getUid();

        collection.document(userId).update("gender", newGender )
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        isEditGenderSuccess.postValue(true);
                        GeneralUser.getInstance().setGender(newGender);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(application.getApplicationContext(), "Edit Gender Failed!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public MutableLiveData<Boolean> getIsEditNameSuccess() {
        return isEditNameSuccess;
    }

    public MutableLiveData<Boolean> getIsEditGenderSuccess() {
        return isEditGenderSuccess;
    }
}
