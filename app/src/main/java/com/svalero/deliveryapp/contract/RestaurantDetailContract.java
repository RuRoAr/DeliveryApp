package com.svalero.deliveryapp.contract;

import com.svalero.deliveryapp.domain.Restaurant;

public interface RestaurantDetailContract {

    interface Model {

        Restaurant getRestaurant(int restaurantId);
    }

    interface View {
        void showRestaurantDetails(Restaurant restaurant);
    }

    interface Presenter {
        void loadRestaurantDetails(int restaurantId);
    }
}
