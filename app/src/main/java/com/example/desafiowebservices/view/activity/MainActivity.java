package com.example.desafiowebservices.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.desafiowebservices.R;
import com.example.desafiowebservices.model.Result;
import com.example.desafiowebservices.view.adapter.AdapterClick;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Result> listagibi = new ArrayList<>();
    private String nomegibi;
    private AdapterClick adapterClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
