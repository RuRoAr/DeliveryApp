package com.svalero.deliveryapp.model;

import com.svalero.deliveryapp.contract.RestaurantDetailContract;
import com.svalero.deliveryapp.domain.Restaurant;

public class RestaurantDetailModel implements RestaurantDetailContract.Model {
    @Override
    public Restaurant getRestaurant(int restaurantId) {
        return null;
    }
}
