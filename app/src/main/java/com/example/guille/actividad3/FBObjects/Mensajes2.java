package com.example.guille.actividad3.FBObjects;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;

/**
 * Created by guille on 19/12/17.
 */
@IgnoreExtraProperties
public class Mensajes2 {

    public HashMap<String,Mensajes> msgs2;

    public Mensajes2(){

    }
    public Mensajes2(HashMap<String,Mensajes> msgs2){
        this.msgs2=msgs2;
    }
}
