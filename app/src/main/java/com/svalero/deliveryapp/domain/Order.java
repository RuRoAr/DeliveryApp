package com.svalero.deliveryapp.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Order implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo
    private long price;
    @ColumnInfo
    private double weight;
    @ColumnInfo
    private boolean ready;
    @ColumnInfo
    private int time;
    @ColumnInfo
    private int distance;


    protected Order(Parcel in) {
        id = in.readLong();
        price = in.readLong();
        weight = in.readDouble();
        ready = in.readByte() != 0;
        time = in.readInt();
        distance = in.readInt();
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Order( long price, double weight, boolean ready, int time, int distance) {

        this.price = price;
        this.weight = weight;
        this.ready = ready;
        this.time = time;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", weight=" + weight +
                ", ready=" + ready +
                ", time=" + time +
                ", distance=" + distance +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeLong(price);
        parcel.writeDouble(weight);
        parcel.writeByte((byte) (ready ? 1 : 0));
        parcel.writeInt(time);
        parcel.writeInt(distance);
    }
}
