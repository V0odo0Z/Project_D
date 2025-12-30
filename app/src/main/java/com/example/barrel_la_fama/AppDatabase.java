package com.example.barrel_la_fama;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Producto.class, Tracker.class}, version=1)
public abstract class AppDatabase extends RoomDatabase {
    //Attributes
    public abstract ProductoDAO ProductoDAO();
    public abstract TrackerDAO TrackerDAO();

    //Attribute to get instance of the db (Singleton pattern)
    //Con volatile me aseguro de que la variable INSTANCE siempre se lea de la main memory, y nunca de la cache del hilo
    private static volatile AppDatabase INSTANCE;

    //Methods
    //Method to get a ddbb instance safetly (Singleton pattern)
    public static AppDatabase getInstance(Context context){
        if (INSTANCE == null){ //Compruebo que ningun hilo este operando con la variable
            synchronized (AppDatabase.class){ //Asegura el thread safety. Evita la ejecucion de de ese bloque de codigo en multiples threads a la vez (solo se ejecuta en un hilo a la vez), evitando que operaciones criticas puedan entrar en conflicto.
                if(INSTANCE == null){ //Double check
                    //Quitar .fallbackToDestructiveMigration() en produccion para evitar perdida de datos en migraciones. (usar solo en desarrollo para facilitarme la vida)
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "Barrel_la_Fama").fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }
}