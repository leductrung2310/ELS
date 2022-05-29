package com.example.els.viewmodel.authentication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class TestVM extends AndroidViewModel {

    String a;

    public TestVM(@NonNull Application application) {
        super(application);
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
