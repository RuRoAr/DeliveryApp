package com.svalero.deliveryapp.presenter;

import android.widget.Toast;

import com.svalero.deliveryapp.R;
import com.svalero.deliveryapp.contract.NewRestaurantContract;
import com.svalero.deliveryapp.domain.Restaurant;
import com.svalero.deliveryapp.model.NewRestaurantModel;
import com.svalero.deliveryapp.view.NewRestaurantView;

public class NewRestaurantPresenter implements NewRestaurantContract.Presenter, NewRestaurantContract.Model.OnAddRestaurantListener {

    private NewRestaurantModel model;
    private NewRestaurantView view;

    public NewRestaurantPresenter(NewRestaurantView view){
        this.view = view;
        model = new NewRestaurantModel(view.getApplicationContext());
    }
    @Override
    public void addRestaurant(String name, String address, String capacity, boolean operative, String mediumPrice, String category) {

        if (name.equals("")) {
                Toast.makeText(view.getApplicationContext(), R.string.restaurant_name_mandatory, Toast.LENGTH_SHORT).show();
                return;
            }

            if (capacity.equals(""))
                capacity = "1";

            if (mediumPrice.equals(""))
                mediumPrice = "0";

           Restaurant restaurant = new Restaurant(name, address, Integer.parseInt(capacity),
                   operative, Float.parseFloat(mediumPrice), category);
        model.addRestaurant(restaurant,this);



    }


    @Override
    public void onAddRestaurantSuccess(Restaurant newRestaurant) {

    }

    @Override
    public void onAddRestaurantError(String message) {

    }
}
