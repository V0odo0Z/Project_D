package com.example.barrel_la_fama;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductoDao {
    @Query("SELECT * FROM productos")
    List<Producto> getAll();

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
    @Delete
    void eliminarProductoById(int ID);
}