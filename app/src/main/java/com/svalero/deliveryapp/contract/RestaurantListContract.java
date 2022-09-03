package com.svalero.deliveryapp.contract;

import android.content.Context;

import com.svalero.deliveryapp.domain.Restaurant;

import java.util.List;

public interface RestaurantListContract {

    interface Model {



        interface OnLoadRestaurantsListener {
          ;
            void onLoadRestaurantsSuccess(List<Restaurant> restaurants);
            void onLoadRestaurantsError(String message);

        }  interface OnDeleteRestaurantListener {
            ;
            void onDeleteRestaurantSuccess();
            void onDeleteRestaurantError(String message);
        }
        void loadAllRestaurants(OnLoadRestaurantsListener listener);
        void deleteRestaurant(OnDeleteRestaurantListener listener, String restaurantId);

    }

    interface View {
        void listAllRestaurants(List<Restaurant> restaurants);
        void showErrorMessage(String message);
    }

    interface Presenter {
        void loadAllRestaurants();

        void deleteRestaurant(String restaurantId);
    }
}

