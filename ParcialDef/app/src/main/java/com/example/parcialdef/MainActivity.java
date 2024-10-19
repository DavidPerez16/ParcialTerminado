package com.example.parcialdef;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edt_pass,edt_user;
    Button btn_entrar;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public static final String dataUserCache = "dataUser";
    private static final int modo_private = Context.MODE_PRIVATE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_user = findViewById(R.id.edt_user);
        edt_pass = findViewById(R.id.edt_pass);
        btn_entrar = findViewById(R.id.btn_entrar);

        sharedPreferences = getSharedPreferences(dataUserCache,modo_private);
        editor =sharedPreferences.edit();

        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edt_user.getText().toString().equals("")||edt_pass.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"No pueden haber campos vacios",Toast.LENGTH_LONG).show();
                }else{
                    editor.putString("usuario",edt_user.getText().toString());
                    editor.commit();
                    Intent i = new Intent(MainActivity.this, rcv_people.class);
                    startActivity(i);
                    finish();
                }
            }
        });


    }
}