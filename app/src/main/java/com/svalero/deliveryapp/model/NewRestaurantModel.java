package com.svalero.deliveryapp.model;

import android.content.Context;

import androidx.room.Room;

import com.svalero.deliveryapp.api.DeliveryApi;
import com.svalero.deliveryapp.api.DeliveryApiInterface;
import com.svalero.deliveryapp.contract.NewRestaurantContract;
import com.svalero.deliveryapp.database.AppDatabase;
import com.svalero.deliveryapp.domain.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewRestaurantModel implements NewRestaurantContract.Model {



    private Context context;
    public NewRestaurantModel(Context context){
        this.context = context;
    }


//    @Override
//    public void addRestaurant(Restaurant restaurant) {
//        AppDatabase db = Room.databaseBuilder(context,AppDatabase.class,"restaurants").allowMainThreadQueries().build();
//        db.restaurantDao().insert(restaurant);
//    }

    @Override
    public void addRestaurant(Restaurant restaurant, OnAddRestaurantListener listener) {

        DeliveryApiInterface api = DeliveryApi.buildInstance();
        Call<Restaurant> callRestaurants = api.addRestaurant(restaurant);

        callRestaurants.enqueue(new Callback<Restaurant>() {
            @Override
            public void onResponse(Call<Restaurant> call, Response<Restaurant> response) {
                Restaurant restaurants = response.body();
                listener.onAddRestaurantSuccess(restaurants);
            }

            @Override
            public void onFailure(Call<Restaurant> call, Throwable t) {
                listener.onAddRestaurantError("Se ha producido un error");
                t.printStackTrace();
            }
        });
    }
}
