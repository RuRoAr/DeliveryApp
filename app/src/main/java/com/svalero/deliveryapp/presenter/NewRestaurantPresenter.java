package com.svalero.deliveryapp.presenter;

import android.widget.Toast;

import com.svalero.deliveryapp.R;
import com.svalero.deliveryapp.contract.NewRestaurantContract;
import com.svalero.deliveryapp.domain.Restaurant;
import com.svalero.deliveryapp.model.NewRestaurantModel;
import com.svalero.deliveryapp.view.NewRestaurantView;

public class NewRestaurantPresenter implements NewRestaurantContract.Presenter {

    private NewRestaurantModel model;
    private NewRestaurantView view;

    public NewRestaurantPresenter(NewRestaurantView view){
        this.view = view;
        model = new NewRestaurantModel(view.getApplicationContext());
    }
    @Override
    public void addRestaurant(String name, String address, String typeFood, String qualification, String recomendation, String mediumPrice, String goBack) {

        if (name.equals("")) {
                Toast.makeText(view.getApplicationContext(), R.string.restaurant_name_mandatory, Toast.LENGTH_SHORT).show();
                return;
            }

            if (qualification.equals(""))
                qualification = "1";

            if (mediumPrice.equals(""))
                mediumPrice = "0";

           Restaurant restaurant = new Restaurant(name,address,typeFood,Float.parseFloat(qualification),
                   recomendation,Float.parseFloat(mediumPrice),goBack);
        model.addRestaurant(restaurant);



    }


}
