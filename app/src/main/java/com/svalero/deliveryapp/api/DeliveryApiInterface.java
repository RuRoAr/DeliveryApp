package com.svalero.deliveryapp.api;

import com.svalero.deliveryapp.domain.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DeliveryApiInterface {
    @GET("restaurants")
    Call<List<Restaurant>> getRestaurants();

    @GET("restaurants/{restaurantId}")
    Call<Restaurant> getRestaurant(@Path("restaurantId") long restaurantId);

    @POST("restaurants")
    Call<Restaurant> addRestaurant(@Body Restaurant restaurant);
}
