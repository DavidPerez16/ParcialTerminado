package com.example.parcialdef.Adaptadores;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcialdef.Clases.People;
import com.example.parcialdef.R;
import com.example.parcialdef.Vista_People;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adaptador_people extends RecyclerView.Adapter<Adaptador_people.ViewHolder>{

    private List<People> datos;
    private Context context;

    public Adaptador_people(Context context, List <People> datos) {
        this.datos = datos;
        this.context=context;

    }

    @NonNull
    @Override
    public Adaptador_people.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_people,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador_people.ViewHolder holder, int position) {
        People dato = datos.get(position);
        holder.bind(dato);
        holder.cardView.setOnClickListener(view -> {
            Intent i= new Intent(context, Vista_People.class);
            i.putExtra("people",dato);
            context.startActivity(i);

        });

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_name,txt_status, txt_type;
        ImageView img_people;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_name= itemView.findViewById(R.id.txt_name);
            txt_status= itemView.findViewById(R.id.txt_status);
            txt_type = itemView.findViewById(R.id.txt_type);
            img_people= itemView.findViewById(R.id.img_people);
            cardView= itemView.findViewById(R.id.card_view);
        }

        public void bind(People dato){
            txt_name.setText(dato.getName());
            txt_status.setText(dato.getStatus());
            txt_type.setText(dato.getType());
            //images
            Picasso.get().load(dato.getImagen()).into(img_people);

        }
    }


}
