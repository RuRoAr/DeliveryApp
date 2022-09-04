package com.svalero.deliveryapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.svalero.deliveryapp.R;
import com.svalero.deliveryapp.contract.OrderListContract;
import com.svalero.deliveryapp.domain.Order;

import com.svalero.deliveryapp.presenter.OrderListPresenter;


import java.util.ArrayList;
import java.util.List;

public class OrderListView extends AppCompatActivity implements OrderListContract.View  {

    private OrderListPresenter presenter;
    private ArrayAdapter<Order> ordersAdapter;//objeto android que hace que el lv liste todo el arrayList
    public List<Order> orderList;// necesito tener una lista para los Restaurantes, lista de la BBDD
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list_view);


        inicializeOrderList();
        presenter = new OrderListPresenter(this);
        presenter.loadAllOrders();


    }
    @Override
    protected void onResume() {
        super.onResume();

        presenter.loadAllOrders();
    }


    private void inicializeOrderList() {
        orderList = new ArrayList<>();
        ordersAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, orderList);
        ListView lvOrders = findViewById(R.id.order_list);
        lvOrders.setAdapter(ordersAdapter);//aqui se emparejan

        registerForContextMenu(lvOrders);

    }


    @Override
    public void listAllOrders(List<Order> orders) {
        orderList.clear();
        orderList.addAll(orders);
        ordersAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_main_order, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_order) {
            Intent intent = new Intent(this, NewOrderView.class);
            intent.putExtra("ACTION", "POST");
            startActivity(intent);
            return true;
        }

        return false;
    }
}