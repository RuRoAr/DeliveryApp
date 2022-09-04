package com.svalero.deliveryapp.presenter;

import com.svalero.deliveryapp.contract.NewRestaurantContract;
import com.svalero.deliveryapp.domain.Restaurant;
import com.svalero.deliveryapp.model.NewRestaurantModel;
import com.svalero.deliveryapp.view.NewRestaurantView;

public class NewRestaurantPresenter implements NewRestaurantContract.Presenter,
        NewRestaurantContract.Model.OnAddRestaurantListener,
        NewRestaurantContract.Model.OnModifyRestaurantListener{

    private NewRestaurantModel model;
    private NewRestaurantView view;

    public NewRestaurantPresenter(NewRestaurantView view){
        this.view = view;
        model = new NewRestaurantModel(view.getApplicationContext());
    }
    @Override
    public void addRestaurant(String name, String address, String capacity, boolean operative, String mediumPrice, String category) {

       if (!validData(name,address, capacity, operative, mediumPrice, category))
            view.showMessage("Error al validar la informacion");
           Restaurant restaurant = new Restaurant(name, address, Integer.parseInt(capacity),
                   operative, Float.parseFloat(mediumPrice), category);
        model.addRestaurant(restaurant,this);



    }
    @Override
    public void onAddRestaurantSuccess(Restaurant newRestaurant) {
        view.showMessage("ok");
    }

    @Override
    public void onAddRestaurantError(String message) {
        view.showMessage("error");
    }

    @Override
    public void modifyRestaurant(long restaurantId, String name, String address, String capacity, boolean operative, String mediumPrice, String category) {
        if (!validData(name,address, capacity, operative, mediumPrice, category))
            view.showMessage("Error al validar la informacion");
        Restaurant restaurant = new Restaurant(name, address, Integer.parseInt(capacity),
                operative, Float.parseFloat(mediumPrice), category);
        restaurant.setId(restaurantId);
        model.modifyRestaurant(restaurantId , restaurant, this);


    }

    private  boolean validData(String name, String address, String capacity, boolean operative, String mediumPrice, String category){
        if (name.equals("")) {
            return false;
        }

        if (capacity.equals(""))
            capacity = "1";

        if (mediumPrice.equals(""))
            mediumPrice = "0";
        return true;
    }
    @Override
    public void onModifyRestaurantSuccess(Restaurant newRestaurant) {
        view.showMessage("ok");
    }

    @Override
    public void onModifyRestaurantError(String message) {
        view.showMessage("error");
    }
}
