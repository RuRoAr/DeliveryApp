package com.svalero.deliveryapp.domain;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity//todo esto es a raiz del room
public class Restaurant implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private String address;
    @ColumnInfo
    private int capacity;
    @ColumnInfo
    private  boolean operative;
    @ColumnInfo(name = "medium_price")
    private float mediumPrice;
    @ColumnInfo
    private String category;


//    @Id
//    private String id;
//    @Field
//    @NotNull
//    @NotEmpty
//    private String name;
//    @Field
//    @NotNull
//    @NotEmpty
//    private String address;
//    @Field
//    @PositiveOrZero
//    private int capacity;
//    @Field
//    private  boolean operative;
//    @Field(name = "medium_price")
//    @PositiveOrZero
//    private float mediumPrice;
//    @Field
//    @NotEmpty
//    private String category;


    public Restaurant(String name, String address, int capacity, boolean operative, float mediumPrice, String category) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.operative = operative;
        this.mediumPrice = mediumPrice;
        this.category = category;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isOperative() {
        return operative;
    }

    public void setOperative(boolean operative) {
        this.operative = operative;
    }

    public float getMediumPrice() {
        return mediumPrice;
    }

    public void setMediumPrice(float mediumPrice) {
        this.mediumPrice = mediumPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", capacity=" + capacity +
                ", operative=" + operative +
                ", mediumPrice=" + mediumPrice +
                ", category='" + category + '\'' +
                '}';
    }
}
