package com.svalero.deliveryapp.presenter;

import com.svalero.deliveryapp.domain.Restaurant;
import com.svalero.deliveryapp.contract.RestaurantListContract;
import com.svalero.deliveryapp.domain.Restaurant;
import com.svalero.deliveryapp.model.RestaurantListModel;
import com.svalero.deliveryapp.view.RestaurantListView;

import java.util.List;

public class RestaurantListPresenter implements RestaurantListContract.Presenter {

    private RestaurantListView view;
    private RestaurantListModel model;

    public RestaurantListPresenter(RestaurantListView view) {
        model = new RestaurantListModel(view.getApplicationContext());
        this.view = view;
    }

    @Override
    public void loadAllRestaurants() {
        List <Restaurant> restaurants = model.loadAllRestaurants();
        view.listAllRestaurants(restaurants);

        double totalCost = model.getTotalCost();
        view.showTotalCost(totalCost);
    }
}
