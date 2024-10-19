package com.example.parcialdef;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parcialdef.Clases.People;
import com.squareup.picasso.Picasso;

public class Vista_People extends AppCompatActivity {
    TextView txt_name,txt_status,txt_type;
    ImageView img_people;
    Button btn_back;

    public static final String dataUserCache = "dataUser";
    private static final int modo_private = Context.MODE_PRIVATE;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String datoShared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_people);

        txt_name= findViewById(R.id.txt_name);
        txt_status= findViewById(R.id.txt_status);
        txt_type = findViewById(R.id.txt_type);
        img_people= findViewById(R.id.img_people);
        btn_back= findViewById(R.id.btn_back);


        sharedPreferences = getSharedPreferences(dataUserCache,modo_private);
        editor =sharedPreferences.edit();

        datoShared = getApplicationContext().getSharedPreferences(dataUserCache,modo_private).getString("usuario","0");


        People pVista = (People) getIntent().getSerializableExtra("people");

        txt_name.setText(pVista.getName());
        txt_status.setText(pVista.getStatus());
        txt_type.setText(pVista.getType());
        Picasso.get().load(pVista.getImagen()).into(img_people);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.commit();
                Intent i = new Intent(Vista_People.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}