package com.svalero.deliveryapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.svalero.deliveryapp.R;
import com.svalero.deliveryapp.contract.RestaurantDetailContract;
import com.svalero.deliveryapp.domain.Restaurant;
import com.svalero.deliveryapp.presenter.RestaurantDetailPresenter;

public class RestaurantDetailView extends AppCompatActivity implements RestaurantDetailContract.View {

    private RestaurantDetailPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail_view);

        presenter = new RestaurantDetailPresenter(this);

        // TODO Recoger el restaurantId del Intent
        int restaurantId = 0;
        presenter.loadRestaurantDetails(restaurantId);

    }

    @Override
    public void showRestaurantDetails(Restaurant restaurant) {

    }
}