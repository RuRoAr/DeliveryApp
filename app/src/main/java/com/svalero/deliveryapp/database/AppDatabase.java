package com.svalero.deliveryapp.database;

//hila el dao con la clase

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.svalero.deliveryapp.dao.RestaurantDao;
import com.svalero.deliveryapp.domain.Restaurant;


@Database(entities = {Restaurant.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract RestaurantDao restaurantDao();

}
