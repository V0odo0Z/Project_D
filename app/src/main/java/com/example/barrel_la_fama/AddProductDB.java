package com.example.barrel_la_fama;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddProductDB extends AppCompatActivity {

    //Atributes
    EditText productName, productPrice, productCategory;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_product_db);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.add_product_db_main_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    productName = findViewById(R.id.anadir_nombre_producto);
    productPrice = findViewById(R.id.anadir_precio_producto);
    productCategory = findViewById(R.id.anadir_categoria_producto);
    button = findViewById(R.id.aceptar_anadir_producto);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Implementar logica de validacion y grabar en bbdd
        }
    });
    }
}