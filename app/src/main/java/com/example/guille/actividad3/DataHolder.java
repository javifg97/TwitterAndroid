package com.example.guille.actividad3;

/**
 * Created by guille on 18/12/17.
 */

public class DataHolder {
    public static DataHolder instances = new DataHolder();

    public FirebaseAdmin firebaseAdmin;

    public DataHolder(){
        this.firebaseAdmin = new FirebaseAdmin();
    }
}
