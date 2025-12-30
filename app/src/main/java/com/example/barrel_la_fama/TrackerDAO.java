package com.example.barrel_la_fama;

import androidx.room.Query;

import java.util.List;

public interface TrackerDAO {
    @Query("SELECT * FROM historico")
    List<Tracker> getAll();
    @Query("SELECT * FROM historico WHERE date = date")
    List<Tracker> sellsByDate(String date); //La pillo y la formateo en el "front end" para pasarla
    @Query("SELECT * FROM historico WHERE productName = productName")
    List<Tracker> sellsByName(String productName);

    //En un principio, no necesito mas metodos. Si quiero buscar por precio o por categoria, hago un getAll() y filtro
}