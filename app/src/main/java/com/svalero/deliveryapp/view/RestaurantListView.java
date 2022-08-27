package com.svalero.deliveryapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.svalero.deliveryapp.R;
import com.svalero.deliveryapp.contract.NewRestaurantContract;
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

    @Override
    protected void onResume() {
        super.onResume();

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
// infla en menu action bar menu/actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_main, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.new_restaurant){
            Intent intent = new Intent(this, NewRestaurantView.class);
            startActivity(intent);
            return  true;
        }
        return false;
    }
}
