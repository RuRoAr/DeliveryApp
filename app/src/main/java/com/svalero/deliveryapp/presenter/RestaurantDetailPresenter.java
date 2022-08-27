package com.svalero.deliveryapp.presenter;

import com.svalero.deliveryapp.contract.RestaurantDetailContract;
import com.svalero.deliveryapp.domain.Restaurant;
import com.svalero.deliveryapp.model.RestaurantDetailModel;
import com.svalero.deliveryapp.view.RestaurantDetailView;

public class RestaurantDetailPresenter implements RestaurantDetailContract.Presenter {

    private RestaurantDetailView view;
    private RestaurantDetailModel model;

    public RestaurantDetailPresenter(RestaurantDetailView view){
        this.view = view;
        model = new RestaurantDetailModel();
    }

    @Override
    public void loadRestaurantDetails(int restaurantId) {
        Restaurant restaurant = model.getRestaurant(restaurantId);
        view.showRestaurantDetails(restaurant);

    }
}
