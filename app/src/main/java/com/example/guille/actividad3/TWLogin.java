package com.example.guille.actividad3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterAuthClient;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class TWLogin extends AppCompatActivity {

    TwitterLoginButton loginButton;
    TextView lblNombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Twitter.initialize(this);
        setContentView(R.layout.activity_twlogin);

        lblNombre = findViewById(R.id.lblNombre);

        loginButton = (TwitterLoginButton) findViewById(R.id.login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                Log.v("HEY","--------------->>>>>>>>>>>>>   "+result.data.getUserName());
                lblNombre.setText(result.data.getUserName());

                // Do something with result, which provides a TwitterSession for making API calls
                /*TwitterAuthClient authClient = new TwitterAuthClient();

                authClient.requestEmail(result.data, new Callback<String>() {
                    @Override
                    public void success(Result<String> result) {
                        Log.v("hey",result.data.toString());
                    }

                    @Override
                    public void failure(TwitterException exception) {
                        // Do something on failure
                    }
                });*/

            }


            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
            }
        });


        /*TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();
        TwitterAuthToken authToken = session.getAuthToken();
        String token = authToken.token;
        String secret = authToken.secret;*/







        /*TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig("vU3b0XygwKfIRcKhySxYvHxiD","li9VxrSswiMzM85WErCA1V5Y9qC8u8U338AUd7e5JtyGjEbff4"))
                .debug(true)
                .build();
        Twitter.initialize(config);*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Pass the activity result to the login button.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }
}
