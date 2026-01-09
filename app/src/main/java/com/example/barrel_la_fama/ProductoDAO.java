package com.example.barrel_la_fama;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductoDAO {
    @Query("SELECT * FROM productos")
    //Al usar LiveData Room hace la consulta en background directamente, evitando asi el cap de no poder ejecutar consultas en el hilo principal (UI thread)
    LiveData<List<Producto>> getAll();

    @Query("SELECT * FROM productos WHERE nombre_producto = :nombreProducto")
    List<Producto> getProductoByName(String nombreProducto);

    @Query("SELECT * FROM productos WHERE id_producto = :idProducto")
    Producto getProductoByID(int idProducto);

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertarProducto(Producto p);

    @Update
    void actualizarProducto(Producto p);

    @Delete
    void eliminarProducto(Producto p);
    @Query("DELETE FROM productos WHERE id_producto = :idProducto")
    void eliminarProductoById(int idProducto);
}