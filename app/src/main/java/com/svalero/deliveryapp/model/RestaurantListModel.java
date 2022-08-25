package com.svalero.deliveryapp.model;

import android.content.Context;

import androidx.room.Room;

import com.svalero.deliveryapp.database.AppDatabase;
import com.svalero.deliveryapp.contract.RestaurantListContract;
import com.svalero.deliveryapp.domain.Restaurant;

import java.util.List;

public class RestaurantListModel implements RestaurantListContract.Model {



    @Override
    public double getTotalCost(Context context) {
            List <Restaurant> restaurants =loadAllRestaurants(context);

        return restaurants.stream()//coge la lista de restaurantes lo combierte en stream
                .map(Restaurant::getMediumPrice)// paso a tener una lista de preciosMedios
                .mapToDouble(mediumPrice -> mediumPrice)//aqui los voy sumando
                .sum();

    }



    @Override
    public List<Restaurant> loadAllRestaurants(Context context) {
        AppDatabase db = Room.databaseBuilder(context
                ,AppDatabase.class, "restaurants").allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();
        return db.restaurantDao().getAll();//el addAll es para que apunte a la misma lista
    }


}
