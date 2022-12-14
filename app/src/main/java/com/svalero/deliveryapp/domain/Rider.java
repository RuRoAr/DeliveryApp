package com.svalero.deliveryapp.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Rider implements Parcelable {

    @PrimaryKey
    private long id;
    @ColumnInfo
    private String dni;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private String surname;
    @ColumnInfo
    private String vehicle;
    @ColumnInfo
    private int maxSpeed;

    public Rider(String dni, String name, String surname, String vehicle, int maxSpeed) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.vehicle = vehicle;
        this.maxSpeed = maxSpeed;
    }

    protected Rider(Parcel in) {
        id = in.readLong();
        dni = in.readString();
        name = in.readString();
        surname = in.readString();
        vehicle = in.readString();
        maxSpeed = in.readInt();
    }

    public static final Creator<Rider> CREATOR = new Creator<Rider>() {
        @Override
        public Rider createFromParcel(Parcel in) {
            return new Rider(in);
        }

        @Override
        public Rider[] newArray(int size) {
            return new Rider[size];
        }
    };

    @Override
    public String toString() {
        return "Rider{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(dni);
        parcel.writeString(name);
        parcel.writeString(surname);
        parcel.writeString(vehicle);
        parcel.writeInt(maxSpeed);
    }
}
