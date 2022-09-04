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
import com.svalero.deliveryapp.contract.NewRiderContract;
import com.svalero.deliveryapp.domain.Rider;
import com.svalero.deliveryapp.presenter.NewRiderPresenter;

public class NewRiderView extends AppCompatActivity implements NewRiderContract.View {
    private NewRiderPresenter presenter;
    private Constants.Action action;
    private Rider rider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_rider_view);
        action = Constants.Action.valueOf(getIntent().getStringExtra("ACTION"));
        if (action == PUT) {
            rider = getIntent().getParcelableExtra("rider");
            fillRiderDetails();
        }


        presenter = new NewRiderPresenter(this);
    }

    private void fillRiderDetails() {

        EditText etDni = findViewById(R.id.rider_dni);
        EditText etName = findViewById(R.id.rider_name);
        EditText etSurname = findViewById(R.id.rider_surname);
        EditText etVehicle = findViewById(R.id.rider_vehicle);
        EditText etMaxSpeed = findViewById(R.id.rider_maxSpeed);


        etDni.setText(String.valueOf(rider.getDni()));
        etName.setText(String.valueOf(rider.getName()));
        etSurname.setText(String.valueOf(rider.getSurname()));
        etVehicle.setText(String.valueOf(rider.getVehicle()));
        etMaxSpeed.setText(String.valueOf(rider.getMaxSpeed()));

    }
    public void addRider(View view){

        EditText etDni = findViewById(R.id.rider_dni);
        EditText etName = findViewById(R.id.rider_name);
        EditText etSurname = findViewById(R.id.rider_surname);
        EditText etVehicle = findViewById(R.id.rider_vehicle);
        EditText etMaxSpeed = findViewById(R.id.rider_maxSpeed);

        String dni = etDni.getText().toString();
        String name = etName.getText().toString();
        String surname = etSurname.getText().toString();
        String vehicle = etVehicle.getText().toString();
        String maxSpeed = etMaxSpeed.getText().toString();

        if (action == POST)
            presenter.addRider( dni,name,  surname, vehicle, Integer.parseInt(maxSpeed));
        else
            presenter.modifyRider( rider.getId(),dni,name,  surname, vehicle, Integer.parseInt(maxSpeed));
//        presenter.addOrder(price,  weight,  ready,  time, distance);


        etDni.setText("");
        etName.setText("");
        etSurname.setText("");
        etVehicle.setText("");
        etMaxSpeed.setText("");
        etName.requestFocus();


    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}