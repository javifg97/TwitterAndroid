package com.example.guille.examen1;

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
