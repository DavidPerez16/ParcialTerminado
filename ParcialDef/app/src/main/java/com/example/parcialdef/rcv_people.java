package com.example.parcialdef;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcialdef.Adaptadores.Adaptador_people;
import com.example.parcialdef.Clases.People;

import java.util.ArrayList;
import java.util.List;

public class rcv_people extends AppCompatActivity {

    RecyclerView rcv_peoplee;

    List<People> listaPeople = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcv_people);

        rcv_peoplee = findViewById(R.id.rcv_people);

        People p1 = new People("https://rickandmortyapi.com/api/character/avatar/80.jpeg","Niñita","Lived","Doll");
        People p2 = new People("https://rickandmortyapi.com/api/character/avatar/40.jpeg","Scorpion","Lived","Alien");
        People p3 = new People("https://rickandmortyapi.com/api/character/avatar/72.jpeg","Rick","Lived","Human");
        People p4 = new People("https://rickandmortyapi.com/api/character/avatar/100.jpeg","Pulga","Lived","Alien");
        People p5 = new People("https://rickandmortyapi.com/api/character/avatar/120.jpeg","Summer","Lived","Human");




        listaPeople.add(p1);
        listaPeople.add(p2);
        listaPeople.add(p3);
        listaPeople.add(p4);
        listaPeople.add(p5);




        rcv_peoplee.setLayoutManager(new LinearLayoutManager(this));
        rcv_peoplee.setAdapter(new Adaptador_people(rcv_people.this,listaPeople));

    }
}