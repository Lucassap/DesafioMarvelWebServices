package com.example.desafiowebservices.viewmodel;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.desafiowebservices.model.Result;
import com.example.desafiowebservices.repository.RepositoryMarvel;
import com.example.desafiowebservices.utils.AppUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.desafiowebservices.utils.AppUtils.md5;

public class ComicViewModel extends AndroidViewModel{
    private MutableLiveData<List<Result>> listMutableLiveData = new MutableLiveData<>();
    private RepositoryMarvel repositoryMarvel = new RepositoryMarvel();
    private CompositeDisposable disposable = new CompositeDisposable();
    public static final String PUBLIC_KEY = "6eb7e8896ec5850c52515a8a23ee97f0";
    public static final String PRIVATE_KEY = "0dd0c16fedb8a02985977eafca66b49f5e6a526f";


    Long   tsLong = System.currentTimeMillis()/1000;
    String ts = tsLong.toString();
    String hash = md5(ts+PRIVATE_KEY+PUBLIC_KEY);

    public ComicViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Result>> getComicsLista(){
        return this.listMutableLiveData;
    }

    public void getComics() {

        disposable.add(
                repositoryMarvel.getAllComicsRepository("magazine", "comic", true, "title", ts, hash, PUBLIC_KEY)

                        .subscribeOn(Schedulers.newThread())

                        .observeOn(AndroidSchedulers.mainThread())

                        .subscribe(response -> {
                            listMutableLiveData.setValue(response.getData().getResults());
                        }, throwable -> {
                            Toast.makeText(getApplication(), "Caiu na merda", Toast.LENGTH_SHORT).show();
                            Log.i("LOG", "Error: " + throwable.getMessage());

                        }));
    }


}
