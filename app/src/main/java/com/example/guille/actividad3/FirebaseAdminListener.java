package com.example.guille.actividad3;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by guille on 18/12/17.
 */

public interface FirebaseAdminListener {
    public void registerOK(boolean itsOk);
    public void loginOK(boolean itsOk);
    public void ramaDescargada(String rama, DataSnapshot dataSnapshot);

}
