package com.svalero.deliveryapp.view;

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

import androidx.annotation.NonNull;
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

    @Override
    protected void onResume() {
        super.onResume();

        presenter.loadAllRestaurants();
    }

    private void inicializeRestaurantList() {

        restaurantList = new ArrayList<>();
        restaurantsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, restaurantList);
        ListView lvRestaurants = findViewById(R.id.restaurants_list);
        lvRestaurants.setAdapter(restaurantsAdapter);//aqui se emparejan

        registerForContextMenu(lvRestaurants);
    }


    @Override
    public void listAllRestaurants(List<Restaurant> restaurants) {
        restaurantList.clear();
        restaurantList.addAll(restaurants);
        restaurantsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    //    @Override
//    public void showTotalCost(double totalCost) {
//        TextView tvSummary = findViewById(R.id.summary);
//        tvSummary.setText(getString(R.string.gastado_en_restaurantes) + totalCost + " €");
//
//    }
// infla en menu action bar menu/actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_restaurant) {
            Intent intent = new Intent(this, NewRestaurantView.class);
            intent.putExtra("ACTION", "POST");
            startActivity(intent);
            return true;
        }else if (item.getItemId() == R.id.show_map) {
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
        }
        return false;
    }

    //manteniendo pulsafo
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {


        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;

        switch (item.getItemId()) {
            case R.id.add_restaurant:
                  Intent intent = new Intent(this, NewRestaurantView.class);
                  intent.putExtra("restaurant", restaurantList.get(position));
                  intent.putExtra("ACTION" , "PUT");
                  startActivity(intent);
                return true;
            case R.id.restaurant_detail:
                //  Intent intent4 = new Intent(this, ListWine.class);
                // startActivity(intent4);
                return true;
            case R.id.delete_restaurant:
                // Intent intent3 = new Intent(this, ListCocktail.class);
                //  startActivity(intent3);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
