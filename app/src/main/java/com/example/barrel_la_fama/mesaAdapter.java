package com.example.barrel_la_fama;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// TODO: Estructura correcta. Empezar a llenar campos

public class mesaAdapter extends RecyclerView.Adapter<mesaAdapter.ViewHolder> {
    @NonNull
    @Override
    public mesaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull mesaAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    // ViewHolder: Clase interna (creada) para manejar la logica de lo que se muestra en cada item
    public static class ViewHolder extends RecyclerView.ViewHolder {

        //Atributos
        Button botonMesa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            botonMesa = itemView.findViewById(R.id.botonMesa);
        }
    }
}