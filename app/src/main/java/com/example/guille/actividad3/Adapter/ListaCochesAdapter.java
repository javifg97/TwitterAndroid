package com.example.guille.actividad3.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guille.actividad3.FBObjects.FBCoche;
import com.example.guille.actividad3.R;

import java.util.ArrayList;

/**
 * Created by guille on 19/12/17.
 */

public class ListaCochesAdapter extends RecyclerView.Adapter<CocheViewHolder> {
    private ArrayList<FBCoche> coches;

    public ListaCochesAdapter(ArrayList<FBCoche> coches) {
        this.coches = coches;
    }

    @Override
    public CocheViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda_coche_layout,null);
        CocheViewHolder cocheViewHolder=new CocheViewHolder(v);
        return cocheViewHolder;
    }

    //vincula contenidos y contenedor
    @Override
    public void onBindViewHolder(CocheViewHolder holder, int position) {
        //holder.textoMensaje.setText(coches.get(position).original);
        holder.tvfabricado.setText(coches.get(position).Fabricado+"");
        holder.tvmarca.setText(coches.get(position).Marca);
        holder.tvnombre.setText(coches.get(position).Nombre);
        holder.tvlat.setText(coches.get(position).lat+"");
        holder.tvlon.setText(coches.get(position).lon+"");
    }

    @Override
    public int getItemCount() {
        return coches.size();
    }
}
//guarda en cada momento que se crea la celda de forma momentanea los datos
class CocheViewHolder extends RecyclerView.ViewHolder{

    public TextView tvfabricado;
    public TextView tvmarca;
    public TextView tvnombre;
    public TextView tvlat;
    public TextView tvlon;



    public CocheViewHolder(View itemView){
        super(itemView);
        tvfabricado=itemView.findViewById(R.id.tvfabricado);
        tvmarca=itemView.findViewById(R.id.tvmarca);
        tvnombre=itemView.findViewById(R.id.tvnombre);
        tvlat=itemView.findViewById(R.id.tvlat);
        tvlon=itemView.findViewById(R.id.tvlon);
    }

}
