package com.svalero.deliveryapp.model;

import android.content.Context;

import androidx.room.Room;

import com.svalero.deliveryapp.contract.NewRestaurantContract;
import com.svalero.deliveryapp.database.AppDatabase;
import com.svalero.deliveryapp.domain.Restaurant;


public class NewRestaurantModel implements NewRestaurantContract.Model {



    private Context context;
    public NewRestaurantModel(Context context){
        this.context = context;
    }


    @Override
    public void addRestaurant(Restaurant restaurant) {
        AppDatabase db = Room.databaseBuilder(context,AppDatabase.class,"restaurants").allowMainThreadQueries().build();
        db.restaurantDao().insert(restaurant);
    }
}
