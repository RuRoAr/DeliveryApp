package com.svalero.deliveryapp.view;

import static com.svalero.deliveryapp.api.Constants.Action.POST;
import static com.svalero.deliveryapp.api.Constants.Action.PUT;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.svalero.deliveryapp.R;
import com.svalero.deliveryapp.api.Constants;
import com.svalero.deliveryapp.contract.NewRestaurantContract;
import com.svalero.deliveryapp.domain.Restaurant;
import com.svalero.deliveryapp.presenter.NewRestaurantPresenter;

public class NewRestaurantView extends AppCompatActivity implements NewRestaurantContract.View {



    private NewRestaurantPresenter presenter;
    private Constants.Action action;
    private Restaurant restaurant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_restaurant_view);

        action = Constants.Action.valueOf(getIntent().getStringExtra("ACTION"));
        if (action == PUT) {
            restaurant = getIntent().getParcelableExtra("restaurant");
            fillRestaurantDetails();
        }
        presenter = new NewRestaurantPresenter(this);
    }

    private void fillRestaurantDetails() {
        EditText etName = findViewById(R.id.restaurant_name);
        EditText etAddress = findViewById(R.id.restaurant_address);
        EditText etCapacity = findViewById(R.id.restaurant_capacity);
        CheckBox checkOperative = findViewById(R.id.checkBox);
        EditText etMediumPrice = findViewById(R.id.restaurant_medium_price);
        EditText etCategoty = findViewById(R.id.restaurant_category);

        etName.setText(restaurant.getName());
        etAddress.setText(restaurant.getAddress());
        etCapacity.setText(String.valueOf(restaurant.getCapacity()));
        etMediumPrice.setText(String.valueOf(restaurant.getMediumPrice()));
        etCategoty.setText(restaurant.getCategory());
        checkOperative.setChecked(restaurant.isOperative());
    }

    public void addRestaurant(View view){

        EditText etName = findViewById(R.id.restaurant_name);
        EditText etAddress = findViewById(R.id.restaurant_address);
        EditText etCapacity = findViewById(R.id.restaurant_capacity);
        CheckBox checkOperative = findViewById(R.id.checkBox);
        EditText etMediumPrice = findViewById(R.id.restaurant_medium_price);
        EditText etCategory = findViewById(R.id.restaurant_category);


        String name = etName.getText().toString();
        String address = etAddress.getText().toString();
        String capacity = etCapacity.getText().toString();
        boolean operative = checkOperative.isChecked();
        String mediumPrice = etMediumPrice.getText().toString();
        String category = etCategory.getText().toString();

        if (action == POST)
            presenter.addRestaurant(name ,address ,capacity,operative, mediumPrice, category);
//        else
//            presenter.modifyRestaurant(restaurant.getId(), name ,address ,capacity,operative, mediumPrice, category );
//        presenter.addRestaurant(name,address,capacity,operative,mediumPrice,category);



        etName.setText("");
        etAddress.setText("");
        etCapacity.setText("");
        etMediumPrice.setText("");
        etCategory.setText("");
        checkOperative.setChecked(false);
        etName.requestFocus();


    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}