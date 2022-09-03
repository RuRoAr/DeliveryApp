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
import com.svalero.deliveryapp.contract.NewOrderContract;
import com.svalero.deliveryapp.domain.Order;

import com.svalero.deliveryapp.presenter.NewOrderPresenter;


public class NewOrderView extends AppCompatActivity implements NewOrderContract.View {
    private NewOrderPresenter presenter;
    private Constants.Action action;
    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order_view);

        action = Constants.Action.valueOf(getIntent().getStringExtra("ACTION"));
        if (action == PUT) {
            order = getIntent().getParcelableExtra("order");
            fillOrderDetails();
        }


        presenter = new NewOrderPresenter(this);
    }

    private void fillOrderDetails() {


        EditText etPrice = findViewById(R.id.order_price);
        EditText etWeight = findViewById(R.id.order_weight);
        EditText etTime = findViewById(R.id.order_time);
        CheckBox checkReady = findViewById(R.id.checkBox_ready);
        EditText etDistance = findViewById(R.id.order_distance);


        etPrice.setText(String.valueOf(order.getPrice()));
        etWeight.setText(String.valueOf(order.getWeight()));
        etTime.setText(String.valueOf(order.getTime()));
        etDistance.setText(String.valueOf(order.getDistance()));
        checkReady.setChecked(order.isReady());
    }
    public void addOrder(View view){

        EditText etPrice = findViewById(R.id.order_price);
        EditText etWeight = findViewById(R.id.order_weight);
        EditText etTime = findViewById(R.id.order_time);
        CheckBox checkReady = findViewById(R.id.checkBox_ready);
        EditText etDistance = findViewById(R.id.order_distance);



        String price = etPrice.getText().toString();
        String weight = etWeight.getText().toString();
        String time = etTime.getText().toString();
        boolean ready = checkReady.isChecked();
        String distance = etDistance.getText().toString();
       ;

        if (action == POST)
            presenter.addOrder(price,  weight,  ready,  time, distance);
//        else
//            presenter.modifyOrder(order.getId(), price,  weight,  ready,  time, distance );
//        presenter.addOrder(price,  weight,  ready,  time, distance);



        etPrice.setText("");
        etWeight.setText("");
        etTime.setText("");
        etDistance.setText("");
        checkReady.setChecked(false);
        etPrice.requestFocus();


    }


    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}