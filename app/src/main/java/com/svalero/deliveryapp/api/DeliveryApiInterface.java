package com.svalero.deliveryapp.api;

import com.svalero.deliveryapp.domain.Order;
import com.svalero.deliveryapp.domain.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DeliveryApiInterface {
    @GET("restaurants")
    Call<List<Restaurant>> getRestaurants();

    @GET("restaurant/{restaurantId}")
    Call<Restaurant> getRestaurant(@Path("restaurantId") long restaurantId);

    @POST("restaurants")
    Call<Restaurant> addRestaurant(@Body Restaurant restaurant);


    // TODO
    @DELETE("restaurant/{restaurantId}")
    Call<Void> deleteRestaurant(@Path("restaurantId") String restaurantId);

    @PUT("restaurant/{restaurantId}")
    Call<Restaurant> modifyRestaurant(@Path("productId") long restaurantId, @Body Restaurant restaurant);



    @GET("orders")
    Call<List<Order>> getOrders();

    @GET("order/{orderId}")
    Call<Order> getOrder(@Path("orderId") long orderId);

    @POST("orders")
    Call<Order> addOrder(@Body Order order);

    @PUT("order/{orderId}")
    Call<Order> modifyOrder(@Path("productId") String orderId, @Body Order order);

}
