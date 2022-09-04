package com.svalero.deliveryapp.presenter;

import com.svalero.deliveryapp.domain.Restaurant;
import com.svalero.deliveryapp.contract.RestaurantListContract;
import com.svalero.deliveryapp.domain.Restaurant;
import com.svalero.deliveryapp.model.RestaurantListModel;
import com.svalero.deliveryapp.view.RestaurantListView;

import java.util.List;

public class RestaurantListPresenter implements RestaurantListContract.Presenter,
        RestaurantListContract.Model.OnLoadRestaurantsListener ,
RestaurantListContract.Model.OnDeleteRestaurantListener{

    private RestaurantListView view;
    private RestaurantListModel model;

    public RestaurantListPresenter(RestaurantListView view) {
        model = new RestaurantListModel(view.getApplicationContext());
        this.view = view;
    }

    @Override
    public void loadAllRestaurants() {
        model.loadAllRestaurants(this);
    }

    @Override
    public void deleteRestaurant(String restaurantId) {
        model.deleteRestaurant( this, restaurantId);

    }


    @Override
    public void onLoadRestaurantsSuccess(List<Restaurant> restaurants) {
        view.listAllRestaurants(restaurants);
    }

    @Override
    public void onLoadRestaurantsError(String message) {
        view.showErrorMessage(message);

    }

    @Override
    public void onDeleteRestaurantSuccess() {
        view.showErrorMessage("Borrado");
    }

    @Override
    public void onDeleteRestaurantError(String message) {

        view.showErrorMessage("Algo ha fallado");
    }



//    @Override
//    public void loadAllRestaurants() {
//        List <Restaurant> restaurants = model.loadAllRestaurants();
//        view.listAllRestaurants(restaurants);
//
//        double totalCost = model.getTotalCost();
//        view.showTotalCost(totalCost);
//    }
}
