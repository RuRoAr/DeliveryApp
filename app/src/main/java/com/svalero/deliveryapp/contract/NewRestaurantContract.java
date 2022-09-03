package com.svalero.deliveryapp.contract;

import com.svalero.deliveryapp.domain.Restaurant;

public interface NewRestaurantContract {

    interface Model {

        interface OnAddRestaurantListener {
            void onAddRestaurantSuccess(Restaurant newRestaurant);
            void onAddRestaurantError(String message);
        }
        void addRestaurant(Restaurant restaurant, OnAddRestaurantListener listener);

        interface OnModifyRestaurantListener {
            void onModifyRestaurantSuccess(Restaurant newRestaurant);
            void onModifyRestaurantError(String message);
        }
        void modifyRestaurant(long restaurantId, Restaurant restaurant, OnModifyRestaurantListener listener);


    }

    interface View {

    void addRestaurant(android.view.View view);
    void showMessage(String message);

    }

    interface Presenter {
    void addRestaurant( String name, String address, String capacity, boolean operative, String mediumPrice, String category);
    void modifyRestaurant(long restaurantId, String name, String address, String capacity, boolean operative, String mediumPrice, String category);


    }
}
