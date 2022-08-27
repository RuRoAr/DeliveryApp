package com.svalero.deliveryapp.contract;

import android.content.Context;

import com.svalero.deliveryapp.domain.Restaurant;

import java.util.List;

public interface NewRestaurantContract {

    interface Model {

        interface OnAddRestaurantListener {
            void onAddRestaurantSuccess(Restaurant newRestaurant);
            void onAddRestaurantError(String message);
        }
        void addRestaurant(Restaurant restaurant, OnAddRestaurantListener listener);


    }

    interface View {

    void addRestaurant(android.view.View view);

    }

    interface Presenter {
    void addRestaurant( String name, String address, String capacity, boolean operative, String mediumPrice, String category);


    }
}
