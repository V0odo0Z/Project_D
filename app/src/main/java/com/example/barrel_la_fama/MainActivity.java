package com.example.barrel_la_fama;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LiveData;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        db = AppDatabase.getInstance(getApplicationContext());
        //Hay que tirarlo con un hilo independiente para evitar el cap del UI Thread de Room
        //Uso lambdas para facilitarlo
        new Thread(() -> db.ProductoDAO().insertarProducto(new Producto("productoPrueba", "22.50", "Comida"))).start();
        LiveData<List<Producto>> listaLD = db.ProductoDAO().getAll();
        listaLD.observe(this, lista -> {
            for(Producto p : lista){
                System.out.println(p.toString());
            }
        });
    }
}

//TODO: La BBDD parece funcionar. Comprobar todas las funcionalidades e introducir los primeros datos