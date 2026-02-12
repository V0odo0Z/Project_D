package com.example.barrel_la_fama;

import static android.content.Intent.ACTION_OPEN_DOCUMENT;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ImportMenu extends AppCompatActivity {
    Uri uri;
    Button acceptButton;
    EditText uriEt;
    //Actividad que espera un resultado. La uso para lanzar el explorador de archivos y esperar el uri
    private ActivityResultLauncher<String[]> filePickerLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_import_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Defino el ActivityResultLauncher. Como parámetros le paso el tipo de resultado que espero (con ActivityResultContracts.OpenDocument()) y la variable donde guardarlo (uri en este caso, que es lo que busco/quiero obtener) y como obtenerlo (con una lambda)
        filePickerLauncher = registerForActivityResult(new ActivityResultContracts.OpenDocument(), uri -> {
            if (uri != null){
                Log.d("URI recibida:", uri.toString());
                this.uri = uri;
                uriEt.setText(uri.toString());
            }
        });
        uriEt = findViewById(R.id.uriCsv);
        acceptButton = findViewById(R.id.boton_aceptar_uri);
        uriEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFile();

            }
        });

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductImporter pi = new ProductImporter(uri);
                pi.importMenu(ImportMenu.this);
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

    //Method to open the file selector, select the file and get the uri
    public void selectFile(){
        //filePickerLauncher.launch(new String[]{"text/csv", "application/pdf"});

        //El filtro new String[]{} solo funciona de esta manera. Poniendo text/csv o text/.csv deja ver el archivo, pero no seleccionarlo
        //Had to do it like that because text/csv only allows to see the file but not to select it
        filePickerLauncher.launch(new String[]{"text/*"});
    }
}