package com.example.guille.actividad3.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.guille.actividad3.R;

//guarda en cada momento que se crea la celda de forma momentanea los datos
public class CocheViewHolder extends RecyclerView.ViewHolder{

    public TextView tvfabricado;
    public TextView tvmarca;
    public TextView tvnombre;
    public TextView tvlat;
    public TextView tvlon;
    public ListaCochesAdapterListener listener;


    public void setListener(ListaCochesAdapterListener listener){
        this.listener=listener;
    }


    public CocheViewHolder(View itemView){
        super(itemView);
        tvfabricado=itemView.findViewById(R.id.tvfabricado);
        tvmarca=itemView.findViewById(R.id.tvmarca);
        tvnombre=itemView.findViewById(R.id.tvnombre);
        tvlat=itemView.findViewById(R.id.tvlat);
        tvlon=itemView.findViewById(R.id.tvlon);
        CocheViewHolderEvents events=new CocheViewHolderEvents(this);
        itemView.setOnClickListener(events);
    }

    class CocheViewHolderEvents implements View.OnClickListener{

        CocheViewHolder cocheViewHolder;

        public CocheViewHolderEvents(CocheViewHolder cocheViewHolder){
            this.cocheViewHolder=cocheViewHolder;
        }

        @Override
        public void onClick(View v) {
            cocheViewHolder.listener.listaCochesAdapterCeldaClicked(cocheViewHolder);
            Log.v("CochesViewHolder", "Clicked");
        }
    }
}
