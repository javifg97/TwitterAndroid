package com.example.guille.actividad3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.guille.actividad3.Adapter.ListaMensajesAdapter;
import com.example.guille.actividad3.FBObjects.Mensajes;
import com.example.guille.milib.ListMensajesFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.ArrayList;
import java.util.Map;

public class SecondActivity extends AppCompatActivity {
    ListMensajesFragment listMensajesFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Log.v("SecondActivity", "-------- email: "+DataHolder.instances.firebaseAdmin.user.getEmail());
        SecondActivityEvents events= new SecondActivityEvents(this);
        DataHolder.instances.firebaseAdmin.setListener(events);
        listMensajesFragment=(ListMensajesFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentListMensajes);
        //selecciona la rama a descargar
        DataHolder.instances.firebaseAdmin.descargarYObservarRama("messages");
       /* ArrayList<String> mdatos=new ArrayList<>();
        mdatos.add("Mensaje 1");
        ListaMensajesAdapter listaMensajesAdapter=new ListaMensajesAdapter(mdatos);
        listMensajesFragment.recyclerView.setAdapter(listaMensajesAdapter);*/
    }
}

class SecondActivityEvents implements  FirebaseAdminListener{
    SecondActivity secondActivity;

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
        GenericTypeIndicator<Map<String,Mensajes>> indicator= new GenericTypeIndicator<Map<String,Mensajes>>(){};
        Map<String,Mensajes> msgs=dataSnapshot.getValue(indicator);
        ListaMensajesAdapter listaMensajesAdapter= new ListaMensajesAdapter(new ArrayList<Mensajes>(msgs.values()));
        secondActivity.listMensajesFragment.recyclerView.setAdapter(listaMensajesAdapter);
    }
}