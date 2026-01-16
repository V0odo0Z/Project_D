package com.example.barrel_la_fama;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.math.BigDecimal;

public class AddProductDB extends AppCompatActivity {

    //Atributes
    EditText productNameET, productPriceET, productCategoryET;
    Button button;
    AppDatabase db;
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

    db = AppDatabase.getInstance(getApplicationContext());
    productNameET = findViewById(R.id.anadir_nombre_producto);
    productPriceET = findViewById(R.id.anadir_precio_producto);
    productCategoryET = findViewById(R.id.anadir_categoria_producto);
    button = findViewById(R.id.aceptar_anadir_producto);
   setStringsBlack();

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Logica de validacion y grabar en bbdd
            try{
                String productName = productNameET.getText().toString().trim();
                BigDecimal productPrice = new BigDecimal(productPriceET.getText().toString().trim());
//Compruebo que el precio no es negativo
                if (productPrice.compareTo(BigDecimal.ZERO) < 0) {
                    Toast.makeText(getApplicationContext(), "El precio no puede ser menor que 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                String productCategory = productCategoryET.getText().toString().trim();

                if (productName.isEmpty() || productCategory.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Nombre y categoría del producto obligatorios", Toast.LENGTH_SHORT).show();
                    return;
                }

                Producto p = new Producto(productName, productPrice.toString(), productCategory);
                new Thread(() -> {db.ProductoDAO().insertarProducto(p);
                    runOnUiThread(() -> Toast.makeText(getApplicationContext(), "Producto introducido en la Base de Datos", Toast.LENGTH_LONG).show())
                    ;}).start();


            }catch (Exception e){
                productPriceET.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
                Toast.makeText(getApplicationContext(), "El formato del precio no es correcto", Toast.LENGTH_LONG).show();
            }
        }
    });
    }

    //Methods
    public void setStringsBlack(){
        productPriceET.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
        productNameET.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
        productCategoryET.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
    }
}