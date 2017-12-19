package com.example.guille.examen1.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guille.examen1.R;

/**
 * Created by guille on 19/12/17.
 */


public class NoticiasViewHolder extends RecyclerView.ViewHolder {

    public TextView tvtitulo;
    public TextView tvnoticia;
    public ImageView imgnot;
    public ListaNoticiasAdapterListener listener;

    public void setListener(ListaNoticiasAdapterListener listener){
        this.listener=listener;
    }

    public NoticiasViewHolder(View itemView){
        super(itemView);
        tvtitulo=itemView.findViewById(R.id.tvtitulo);
        tvnoticia=itemView.findViewById(R.id.tvnoticia);
        imgnot=itemView.findViewById(R.id.imgnot);
        NoticiasViewHolderEvents events=new NoticiasViewHolderEvents(this);
        itemView.setOnClickListener(events);

    }

}

class NoticiasViewHolderEvents implements View.OnClickListener{

    NoticiasViewHolder noticiasViewHolder;

    public NoticiasViewHolderEvents(NoticiasViewHolder noticiasViewHolder){
        this.noticiasViewHolder=noticiasViewHolder;
    }

    @Override
    public void onClick(View v) {
        noticiasViewHolder.listener.listaNoticiasAdapterCeldaClicked(noticiasViewHolder);
        Log.v("NoticiasViewHolder", "Clicked");
    }
}
