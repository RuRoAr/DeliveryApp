package com.svalero.deliveryapp.model;

import android.content.Context;

import androidx.room.Room;

import com.svalero.deliveryapp.database.AppDatabase;
import com.svalero.deliveryapp.contract.RestaurantListContract;
import com.svalero.deliveryapp.domain.Restaurant;

import java.util.List;

public class RestaurantListModel implements RestaurantListContract.Model {

    private Context context;

    public RestaurantListModel(Context context){
        this.context = context;
    }


    @Override
    public double getTotalCost() {
            List <Restaurant> restaurants =loadAllRestaurants();

        return restaurants.stream()//coge la lista de restaurantes lo combierte en stream
                .map(Restaurant::getMediumPrice)// paso a tener una lista de preciosMedios
                .mapToDouble(mediumPrice -> mediumPrice)//aqui los voy sumando
                .sum();

    }



    @Override
    public List<Restaurant> loadAllRestaurants() {
        AppDatabase db = Room.databaseBuilder(context
                ,AppDatabase.class, "restaurants").allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();
        return db.restaurantDao().getAll();//el addAll es para que apunte a la misma lista
    }


}
