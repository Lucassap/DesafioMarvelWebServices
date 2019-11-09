package com.example.desafiowebservices.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import io.reactivex.disposables.CompositeDisposable;

public class ComicViewModel extends AndroidViewModel {

    private CompositeDisposable disposable = new CompositeDisposable();
    public static final String PUBLIC_KEY = "6eb7e8896ec5850c52515a8a23ee97f0";
    public static final String PRIVATE_KEY = "0dd0c16fedb8a02985977eafca66b49f5e6a526f";


    public ComicViewModel(@NonNull Application application) {
        super(application);
    }


}
