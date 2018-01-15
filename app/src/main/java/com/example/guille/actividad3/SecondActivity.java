package com.example.guille.actividad3;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.guille.actividad3.Adapter.CocheViewHolder;
import com.example.guille.actividad3.Adapter.ListaCochesAdapter;
import com.example.guille.actividad3.Adapter.ListaCochesAdapterListener;
import com.example.guille.actividad3.Adapter.ListaMensajesAdapter;
import com.example.guille.actividad3.FBObjects.FBCoche;
import com.example.guille.actividad3.FBObjects.Mensajes;
import com.example.guille.milib.ListaFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.ArrayList;
import java.util.Map;

public class SecondActivity extends AppCompatActivity {
    ListaFragment listaFragmentCoches;
    //ListaFragment listaFragmentMensajes;
    ListaCochesAdapter listaCochesAdapter;
    SupportMapFragment mapFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Log.v("SecondActivity", "-------- email: "+DataHolder.instances.firebaseAdmin.user.getEmail());
        SecondActivityEvents events= new SecondActivityEvents(this);
        DataHolder.instances.firebaseAdmin.setListener(events);
        //listaFragmentMensajes =(ListaFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentListMensajes);
        listaFragmentCoches =(ListaFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentListCoche);
         mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentMapa);
        mapFragment.getMapAsync(events);

        //selecciona la rama a descargar
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //transaction.hide(listaFragmentMensajes);
        transaction.hide(listaFragmentCoches);
        transaction.show(mapFragment);
        transaction.commit();
        //DataHolder.instances.firebaseAdmin.descargarYObservarRama("messages");

       /* ArrayList<String> mdatos=new ArrayList<>();
        mdatos.add("Mensaje 1");
        ListaMensajesAdapter listaMensajesAdapter=new ListaMensajesAdapter(mdatos);
        listaFragment.recyclerView.setAdapter(listaMensajesAdapter);*/
    }
}

class SecondActivityEvents implements  FirebaseAdminListener, OnMapReadyCallback, ListaCochesAdapterListener {
    SecondActivity secondActivity;
    GoogleMap mMap;
    ArrayList<FBCoche> coches;

    public SecondActivityEvents(SecondActivity secondActivity){
        this.secondActivity=secondActivity;

    }
    @Override
    public void registerOK(boolean itsOk) {

    }

    @Override
    public void loginOK(boolean itsOk) {

    }

    @Override
    public void ramaDescargada(String rama, DataSnapshot dataSnapshot) {
        Log.v("SecondActivity", rama+"------- "+dataSnapshot);
        //Mensajes2 mensajes2=dataSnapshot.getValue(Mensajes2.class);
       // Log.v("SecondActivity", "Mensaje:  "+mensajes2.msgs2);
        if(rama.equals("messages")){
            /*GenericTypeIndicator<Map<String,Mensajes>> indicator= new GenericTypeIndicator<Map<String,Mensajes>>(){};
            Map<String,Mensajes> msgs=dataSnapshot.getValue(indicator);
            ListaMensajesAdapter listaMensajesAdapter= new ListaMensajesAdapter(new ArrayList<Mensajes>(msgs.values()));
            secondActivity.listaFragmentMensajes.recyclerView.setAdapter(listaMensajesAdapter);
            FragmentTransaction transaction= secondActivity.getSupportFragmentManager().beginTransaction();
            transaction.remove(secondActivity.listaFragmentMensajes);
            transaction.commit();*/
        }else if(rama.equals("Coches")){
            GenericTypeIndicator<ArrayList<FBCoche>> indicator= new GenericTypeIndicator<ArrayList<FBCoche>>(){};
            coches=dataSnapshot.getValue(indicator);
            secondActivity.listaCochesAdapter= new ListaCochesAdapter(coches);
            secondActivity.listaFragmentCoches.recyclerView.setAdapter(secondActivity.listaCochesAdapter);
            secondActivity.listaCochesAdapter.setListener(this);
            agregarPinesCoches();

        }

    }

    public void agregarPinesCoches(){
        for (int i=0;i<coches.size();i++){
            FBCoche cocheTemp=coches.get(i);
            LatLng cochePos = new LatLng(cocheTemp.lat, cocheTemp.lon);
            MarkerOptions markerOptions= new MarkerOptions();
            markerOptions.position(cochePos);
            markerOptions.title(cocheTemp.Nombre);
            if (mMap!=null){
                mMap.addMarker(markerOptions);

            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        /*LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
        DataHolder.instances.firebaseAdmin.descargarYObservarRama("Coches");

    }

    @Override
    public void listaCochesAdapterCeldaClicked(CocheViewHolder celdaHolder) {
        Log.v("SecondActivity", "Celda presionada:  "+celdaHolder.getAdapterPosition());

    }
}