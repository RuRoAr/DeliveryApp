package com.svalero.deliveryapp.contract;

import android.content.Context;

import com.svalero.deliveryapp.domain.Restaurant;

import java.util.List;

public interface NewRestaurantContract {

    interface Model {

        void addRestaurant(Restaurant restaurant);


    }

    interface View {

    void addRestaurant(android.view.View view);

    }

    interface Presenter {
    void addRestaurant(String name,String address,String typeFood,String qualification,
                       String recomendation,String mediumPrice,String goBack);


    }
}
