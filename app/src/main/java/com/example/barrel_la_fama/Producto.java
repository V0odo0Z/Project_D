package com.example.barrel_la_fama;

import java.math.BigDecimal;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

@Entity (tableName = "productos")
public class Producto {

    //Atributos
    @PrimaryKey //(autoGenerate = true)
    @ColumnInfo (name = "id_producto")
    public int idProducto;
    @ColumnInfo(name = "nombre_producto")
    public String nombreProducto;
    @ColumnInfo(name = "precio")
    public String precio;
    @ColumnInfo(name = "categoria_producto")
    public String categoriaProducto;

    //Constructor

    public Producto (String nombreProducto, String precio, String categoriaProducto){
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.categoriaProducto = categoriaProducto;
    }


}