package com.example.guille.actividad3;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.content.ContentValues.TAG;

/**
 * Created by guille on 18/12/17.
 */

public class FirebaseAdmin {

    private FirebaseAuth mAuth;
    private FirebaseAdminListener listener;
    public FirebaseUser user;

    public  FirebaseAdmin(){
        mAuth = FirebaseAuth.getInstance();
    }
    public void setListener(FirebaseAdminListener listener){
        this.listener = listener;
    }

    public void RegisterEmailPass(String email, String pass, Activity activity){

        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (task.isSuccessful()) {
                            user = FirebaseAuth.getInstance().getCurrentUser();
                            listener.registerOK(true);
                        }else{
                            listener.registerOK(false);
                        }

                        // ...
                    }
                });

    }

    public void LoginEmailPass(String email, String pass, Activity activity){

        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (task.isSuccessful()) {
                            user = FirebaseAuth.getInstance().getCurrentUser();
                            listener.loginOK(true);
                        }else{
                            listener.loginOK(false);
                        }

                        // ...
                    }
                });

    }

}


