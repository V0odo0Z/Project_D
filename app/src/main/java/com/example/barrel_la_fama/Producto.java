package com.example.barrel_la_fama;

import java.math.BigDecimal;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

@Entity (tableName = "productos")
public class Producto {

    //Atributos
    @PrimaryKey //(autoGenerate = true)
    @ColumnInfo (name = "id_producto")
    //El ID NO puede ser int, porque int no puede ser null. TIENE que ser INTEGER por necesidad
    public Integer idProducto;
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

    @Ignore
    public Producto (Integer idProducto, String nombreProducto, String precio, String categoriaProducto){
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.categoriaProducto = categoriaProducto;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "categoriaProducto='" + categoriaProducto + '\'' +
                ", idProducto=" + idProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}