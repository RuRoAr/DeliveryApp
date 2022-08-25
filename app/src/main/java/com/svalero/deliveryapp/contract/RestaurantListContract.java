package com.svalero.deliveryapp.contract;

import android.content.Context;

import com.svalero.deliveryapp.domain.Restaurant;

import java.util.List;

public interface RestaurantListContract {



    interface Model {
        double getTotalCost(Context context);
        List<Restaurant> loadAllRestaurants(Context context);

    }

    interface View {

        void showTotalCost(double totalCost);
        void listAllRestaurants(List <Restaurant> restaurants);

    }

    interface Presenter {
        void loadAllRestaurants();

    }
}

