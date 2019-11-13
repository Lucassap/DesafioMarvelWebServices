package com.example.desafiowebservices.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.example.desafiowebservices.R;
import com.example.desafiowebservices.model.Result;
import com.example.desafiowebservices.view.adapter.AdapterClick;
import com.example.desafiowebservices.view.adapter.OnClickGibi;
import com.example.desafiowebservices.viewmodel.ComicViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity  implements OnClickGibi {
    private RecyclerView recyclerView;
    private List<Result> listagibi = new ArrayList<>();
    private String nomegibi;
    private AdapterClick adapterClick;
    private ComicViewModel comicViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(adapterClick);
    }

    


    private void initViews() {

        recyclerView = findViewById(R.id.recycler);
        adapterClick = new AdapterClick(listagibi, this);
        recyclerView.setAdapter(adapterClick);
        comicViewModel = ViewModelProviders.of(this).get(ComicViewModel.class);
    }

    @Override
    public void onClickGibi(Result result) {
        Intent intent = new Intent(MainActivity.this, DetalheActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }

}

