package com.example.guille.actividad3.FBObjects;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by guille on 19/12/17.
 */
// se crea la clase para la rama de donde vamos a sacar los datos
@IgnoreExtraProperties
public class Mensajes {

    public String original;

    public Mensajes(){

    }
    public Mensajes(String original){
        this.original=original;
    }
}
