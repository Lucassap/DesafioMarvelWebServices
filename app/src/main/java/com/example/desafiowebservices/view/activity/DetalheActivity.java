package com.example.desafiowebservices.view.activity;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.desafiowebservices.R;
import com.example.desafiowebservices.model.Result;
import com.squareup.picasso.Picasso;

import static com.example.desafiowebservices.view.activity.MainActivity.COMIC_KEY;

public class DetalheActivity extends AppCompatActivity {
    TextView descricão;
    ImageView capagibi;
    TextView nomegibi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        descricão = findViewById(R.id.detalhedescricao);
        capagibi = findViewById(R.id.detalhecapagibi);
        nomegibi = findViewById(R.id.detalhenomegibi);

        if(getIntent().getExtras() != null ){
            Result comic = getIntent().getExtras().getParcelable(COMIC_KEY);
            //Picasso.get().load(comic.getThumbnail().getPath() + ".jpg")
             //       .error(R.drawable.comicdefault)
             //       .into(capagibi);
            nomegibi.setText(comic.getTitle());
            descricão.setText(comic.getDescription());
        }

        getSupportActionBar().hide();

    }
}
