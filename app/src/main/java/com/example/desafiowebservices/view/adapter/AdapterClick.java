package com.example.desafiowebservices.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desafiowebservices.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterClick extends RecyclerView.Adapter<AdapterClick.ViewHolder> {

    private List<com.example.desafiowebservices.model.Result> listagibi;
    private OnClickGibi onClickGibi;

    public AdapterClick (List<com.example.desafiowebservices.model.Result> listagibi, OnClickGibi onClickGibi){
        this.listagibi = listagibi;
        this.onClickGibi = onClickGibi;
    }

    @NonNull
    @Override
    public AdapterClick.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comic_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClick.ViewHolder holder, int position) {
        com.example.desafiowebservices.model.Result comic = this.listagibi.get(position);
        holder.bind(comic);

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onClickGibi.onClickGibi(comic);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listagibi.size();
    }

    public void setUpdate(List<com.example.desafiowebservices.model.Result> listagibi) {
        if (this.listagibi.isEmpty()){
            this.listagibi = listagibi;
        }else {
            this.listagibi.addAll(listagibi);
        }
        notifyDataSetChanged();
    }

    public void clear(){
        this.listagibi.clear();
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView IVcapagibi;
        TextView TVnomegibi;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            IVcapagibi = itemView.findViewById(R.id.capagibi);
            TVnomegibi = itemView.findViewById(R.id.nomegibi);

        }

        public void bind(com.example.desafiowebservices.model.Result comic){
            TVnomegibi.setText(comic.getTitle());
            Picasso.get().load(comic.getThumbnail().getPath() + ".jpg").into(IVcapagibi);
        }
    }
}
