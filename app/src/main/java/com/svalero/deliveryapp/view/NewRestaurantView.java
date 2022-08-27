package com.svalero.deliveryapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.svalero.deliveryapp.R;
import com.svalero.deliveryapp.contract.NewRestaurantContract;
import com.svalero.deliveryapp.domain.Restaurant;
import com.svalero.deliveryapp.presenter.NewRestaurantPresenter;

public class NewRestaurantView extends AppCompatActivity implements NewRestaurantContract.View {

    private NewRestaurantPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_restaurant_view);

        presenter = new NewRestaurantPresenter(this);
    }

    public void addRestaurant(View view){

        EditText etName = findViewById(R.id.restaurant_name);
        EditText etAddress = findViewById(R.id.restaurant_address);
        EditText etTypeFood = findViewById(R.id.restaurant_type_food);
        EditText etQualification = findViewById(R.id.restaurant_qualification);
        EditText etRecomendation = findViewById(R.id.restaurrant_recommendation);
        EditText etMediumPrice = findViewById(R.id.restaurant_medium_price);
        EditText etGoBack = findViewById(R.id.restaurant_go_back);


        String name = etName.getText().toString();
        String address = etAddress.getText().toString();
        String typeFood = etTypeFood.getText().toString();
        String qualification =  etQualification.getText().toString();
        String recomendation = etRecomendation.getText().toString();
        String mediumPrice = etMediumPrice.getText().toString();
        String goBack = etGoBack.getText().toString();



        presenter.addRestaurant(name,address,typeFood,qualification,
                recomendation,mediumPrice,goBack);

        Toast.makeText(this, getString(R.string.restaurant_added, name), Toast.LENGTH_SHORT).show();

        etName.setText("");
        etAddress.setText("");
        etGoBack.setText("");
        etMediumPrice.setText("");
        etRecomendation.setText("");
        etTypeFood.setText("");
        etQualification.setText("");
        etName.requestFocus();


    }
}