package com.svalero.deliveryapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.svalero.deliveryapp.R;
import com.svalero.deliveryapp.contract.NewRestaurantContract;
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
        EditText etCapacity = findViewById(R.id.restaurant_capacity);
        CheckBox checkOperative = findViewById(R.id.checkBox);
        EditText etMediumPrice = findViewById(R.id.restaurant_medium_price);
        EditText etCategoty = findViewById(R.id.restaurant_category);


        String name = etName.getText().toString();
        String address = etAddress.getText().toString();
        String capacity = etCapacity.getText().toString();
        boolean operative = checkOperative.isChecked();
        String mediumPrice = etMediumPrice.getText().toString();
        String category = etCategoty.getText().toString();



        presenter.addRestaurant(name,address,capacity,operative,mediumPrice,category);

        Toast.makeText(this, getString(R.string.restaurant_added, name), Toast.LENGTH_SHORT).show();

        etName.setText("");
        etAddress.setText("");
        etCapacity.setText("");
        etMediumPrice.setText("");
        etCategoty.setText("");
        checkOperative.setChecked(false);
        etName.requestFocus();


    }
}