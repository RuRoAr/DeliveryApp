package com.svalero.deliveryapp.model;

import android.content.Context;

import androidx.room.Room;

import com.svalero.deliveryapp.api.DeliveryApi;
import com.svalero.deliveryapp.api.DeliveryApiInterface;
import com.svalero.deliveryapp.database.AppDatabase;
import com.svalero.deliveryapp.contract.RestaurantListContract;
import com.svalero.deliveryapp.domain.Restaurant;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantListModel implements RestaurantListContract.Model {

    private Context context;

    public RestaurantListModel(Context context){
        this.context = context;
    }

    @Override
    public void loadAllRestaurants(OnLoadRestaurantsListener listener) {



        DeliveryApiInterface api = DeliveryApi.buildInstance();
        Call<List<Restaurant>> callRestaurants = api.getRestaurants();

        callRestaurants.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {
                List<Restaurant> restaurants = response.body();
                listener.onLoadRestaurantsSuccess(restaurants);
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {
                listener.onLoadRestaurantsError("Se ha producido un error");
                t.printStackTrace();
            }
        });

    }

//
//    @Override
//    public double getTotalCost() {
//            List <Restaurant> restaurants =loadAllRestaurants();
//
//        return restaurants.stream()//coge la lista de restaurantes lo combierte en stream
//                .map(Restaurant::getMediumPrice)// paso a tener una lista de preciosMedios
//                .mapToDouble(mediumPrice -> mediumPrice)//aqui los voy sumando
//                .sum();
//
//    }
//
//
//
//    @Override
//    public List<Restaurant> loadAllRestaurants() {
//        AppDatabase db = Room.databaseBuilder(context
//                ,AppDatabase.class, "restaurants").allowMainThreadQueries()
//                .fallbackToDestructiveMigration().build();
//        return db.restaurantDao().getAll();//el addAll es para que apunte a la misma lista
//    }


}
