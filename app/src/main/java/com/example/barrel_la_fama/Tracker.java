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
    private String price; //Precio de venta

    //Constructor
    public Tracker(){}

    //Methods
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdEntry() {
        return idEntry;
    }

    public void setIdEntry(int idEntry) {
        this.idEntry = idEntry;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
