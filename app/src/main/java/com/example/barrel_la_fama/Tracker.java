package com.example.barrel_la_fama;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.math.BigDecimal;

@Entity(tableName = "historico")
public class Tracker {

    //Atributes
    @PrimaryKey(autoGenerate = true)
    private int idEntry;
    @ColumnInfo(name = "idItem")
    private int idItem;
    @ColumnInfo (name = "productName")
    private String productName;
    @ColumnInfo(name = "quantity")
    private int quantity; //Cantidad vendida del item
    @ColumnInfo(name = "date")
    private String date; //Fecha de la venta
    @ColumnInfo(name = "price")
    private BigDecimal price; //Precio de venta

    //Constructor
    public Tracker(){}

    //Methods
}
