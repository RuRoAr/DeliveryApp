package com.svalero.deliveryapp.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity//todo esto es a raiz del room
public class Restaurant implements Parcelable {

    @PrimaryKey
    @NonNull
    private long id;
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





    public Restaurant(String name, String address, int capacity, boolean operative, float mediumPrice, String category) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.operative = operative;
        this.mediumPrice = mediumPrice;
        this.category = category;
    }


    protected Restaurant(Parcel in) {
        id = Long.parseLong(in.readString());
        name = in.readString();
        address = in.readString();
        capacity = in.readInt();
        operative = in.readByte() != 0;
        mediumPrice = in.readFloat();
        category = in.readString();
    }

    public Restaurant() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(String.valueOf(id));
        dest.writeString(name);
        dest.writeString(address);
        dest.writeInt(capacity);
        dest.writeByte((byte) (operative ? 1 : 0));
        dest.writeFloat(mediumPrice);
        dest.writeString(category);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
