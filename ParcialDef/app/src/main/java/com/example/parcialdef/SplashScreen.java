package com.example.parcialdef;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {

    public static final String dataUserCache = "dataUser";
    private static final int modo_private = Context.MODE_PRIVATE;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        validarLogin();
    }
    private void validarLogin() {
        token = getApplicationContext().getSharedPreferences(dataUserCache,modo_private).getString("usuario","0");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (token.equalsIgnoreCase("0")){
                    Intent i = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }else {

                    Intent i = new Intent(SplashScreen.this, rcv_people.class);
                    startActivity(i);
                    finish();
                }
            }
        },3000);


    }
}