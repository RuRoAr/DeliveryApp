package com.svalero.deliveryapp.view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.svalero.deliveryapp.R;
import com.svalero.deliveryapp.contract.RestaurantListContract;
import com.svalero.deliveryapp.domain.Restaurant;
import com.svalero.deliveryapp.presenter.RestaurantListPresenter;

import java.util.ArrayList;
import java.util.List;

public class RestaurantListView extends AppCompatActivity implements RestaurantListContract.View {// el lisener es para escuchar el click de la pantalla {

    private RestaurantListPresenter presenter;
    private ArrayAdapter<Restaurant> restaurantsAdapter;//objeto android que hace que el lv liste todo el arrayList
    public List<Restaurant> restaurantList;// necesito tener una lista para los Restaurantes, lista de la BBDD

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializeRestaurantList();
        presenter = new RestaurantListPresenter(this);
        presenter.loadAllRestaurants();


    }
    private void inicializeRestaurantList(){

        restaurantList = new ArrayList<>();
        restaurantsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, restaurantList);
        ListView lvRestaurants = findViewById(R.id.restaurants_list);
        lvRestaurants.setAdapter(restaurantsAdapter);//aqui se emparejan
    }


    @Override
    public void listAllRestaurants(List<Restaurant> restaurants) {
        restaurantList.clear();
        restaurantList.addAll(restaurants);
        restaurantsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showTotalCost(double totalCost) {
        TextView tvSummary = findViewById(R.id.summary);
        tvSummary.setText(getString(R.string.gastado_en_restaurantes) + totalCost + " €");

    }




}
