package com.example.barrel_la_fama;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.zip.DataFormatException;

import android.content.ContentResolver;
import android.util.Log;
import android.widget.Toast;

public class ProductImporter {
    //Atributes
    Uri uriMenu;
    int lines, errors;

    //Constructor

    ProductImporter(Uri uriMenu){
        this.uriMenu = uriMenu;
        lines = 0;
        errors = 0;
    }

    //Methods
    public void importMenu(Activity activity){
        AppDatabase db = AppDatabase.getInstance(activity.getApplicationContext());
        //I'll do it all in a thread to avoid opening one thread per Product when saving in the DB
        new Thread (()-> {
            //Elimino todos los registros anteriores
            db.ProductoDAO().eliminarProductosAll();

            Log.i("BBDD", "Todos los PRODUCTOS eliminados");
        try (InputStream is = activity.getApplicationContext().getContentResolver().openInputStream(uriMenu);
             BufferedReader br = new BufferedReader(new InputStreamReader(is));){

            String line;
            while((line = br.readLine())!= null){
                if(line.trim().isEmpty()){
                    continue;
                }

                String [] productData = line.split(";");

                if(productData.length < 3){
                    errors++;
                    continue;
                }

                String category = productData [0].trim();
                String name = productData[1].trim();
                String price = "0";
                try{
                    BigDecimal priceBD = new BigDecimal(productData[2].trim());
                    price = priceBD.toString();

                }
                catch (NumberFormatException e){
                    Log.e("DATA ERROR", "Problema en la conversion del precio (String <--> BigDecimal)");
                    Log.e("DATA ERROR", e.toString());
                }

                Producto p = new Producto(name, price, category);

                db.ProductoDAO().insertarProducto(p);
                lines++;
            }
        } catch (Exception e) {
            Log.e("STREAM ERROR", "Error con los streams en ProductImporter");
            errors++;
        }
        String mensaje = "Lineas insertadas: "+lines+" \n Errores: "+errors;
        activity.runOnUiThread(() -> Toast.makeText(activity, mensaje,Toast.LENGTH_LONG).show());
        }).start();
    }
}