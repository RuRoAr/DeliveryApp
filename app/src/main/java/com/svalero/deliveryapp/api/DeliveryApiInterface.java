package com.svalero.deliveryapp.api;

import com.svalero.deliveryapp.domain.Order;
import com.svalero.deliveryapp.domain.Restaurant;
import com.svalero.deliveryapp.domain.Rider;

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
    Call<Restaurant> modifyRestaurant(@Path("restaurantId") long restaurantId, @Body Restaurant restaurant);



    @GET("orders")
    Call<List<Order>> getOrders();

    @GET("order/{orderId}")
    Call<Order> getOrder(@Path("orderId") long orderId);

    @POST("orders")
    Call<Order> addOrder(@Body Order order);

    @PUT("order/{orderId}")
    Call<Order> modifyOrder(@Path("orderId") String orderId, @Body Order order);


    @GET("riders")
    Call<List<Rider>> getRiders();

    @GET("rider/{riderId}")
    Call<Rider> getRider(@Path("riderId") long riderId);

    @POST("riders")
    Call<Rider> addRider(@Body Rider rider);

    @PUT("rider/{riderId}")
    Call<Rider> modifyRider(@Path("riderId") long riderId, @Body Rider rider);

    @DELETE("rider/{riderId}")
    Call<Void> deleteRider(@Path("riderId") String riderId);


}
