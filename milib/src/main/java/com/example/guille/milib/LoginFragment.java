package com.example.guille.milib;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    public EditText txtfEmail;
    public EditText txtfPas;
    public Button btnLog;
    public Button btnReg;
    public LoginFragmentEvents events;
    public LoginFragmentListener listener;


    public void setListener(LoginFragmentListener listener) {

        this.listener = listener;
    }

    public LoginFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        events = new LoginFragmentEvents(this);

        txtfEmail = v.findViewById(R.id.edTEmailLog);
        txtfPas = v.findViewById(R.id.edTPassLog);

        btnLog = v.findViewById(R.id.btnLogin);
        btnReg = v.findViewById(R.id.btnRegister);

        btnReg.setOnClickListener(events);
        btnLog.setOnClickListener(events);

        return v;
    }




}
class LoginFragmentEvents implements View.OnClickListener{

    public LoginFragment login;

    public LoginFragmentEvents(LoginFragment login){

        this.login = login;

    }


    public void onClick(View view) {
        if (view.getId() == R.id.btnRegister) {
            this.login.listener.OnclickedRegisterButton();

        } else if (view.getId() == R.id.btnLogin) {
            this.login.listener.OnclickedLoginButton(login.txtfEmail.getText().toString(),login.txtfPas.getText().toString());
        }
    }

}
