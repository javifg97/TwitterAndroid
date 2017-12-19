package com.example.guille.examen1.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guille.examen1.R;

/**
 * Created by guille on 19/12/17.
 */

public class ListaNoticiasAdapter extends RecyclerView.Adapter<NoticiasViewHolder> {
    private ArrayList<FBNoticia> noticias;

    @Override
    public NoticiasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda_noticia_layout,null);
        NoticiasViewHolder noticiasViewHolder=new NoticiasViewHolder(v);
        return noticiasViewHolder;    }

    @Override
    public void onBindViewHolder(NoticiasViewHolder holder, int position) {
        holder.tvtitulo.setText(noticias.get(position).Titulo+"");
        holder.tvnoticia.setText(noticias.get(position).Noticia+"");

    }

    @Override
    public int getItemCount() {
        return noticias.size();    }
}


class NoticiasViewHolder extends RecyclerView.ViewHolder {

    public TextView tvtitulo;
    public TextView tvnoticia;

    public NoticiasViewHolder(View itemView){
        super(itemView);
        tvtitulo=itemView.findViewById(R.id.tvtitulo);
        tvnoticia=itemView.findViewById(R.id.tvnoticia);
    }

}
