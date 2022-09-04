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
import com.svalero.deliveryapp.contract.RiderListContract;
import com.svalero.deliveryapp.domain.Rider;
import com.svalero.deliveryapp.presenter.RiderListPresenter;

import java.util.ArrayList;
import java.util.List;

public class RiderListView extends AppCompatActivity implements RiderListContract.View {
    private RiderListPresenter presenter;
    private ArrayAdapter<Rider> ridersAdapter;//objeto android que hace que el lv liste todo el arrayList
    public List<Rider> riderList;// necesito tener una lista para los Restaurantes, lista de la BBD
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_list_view);

        inicialiceRiderList();
        presenter = new RiderListPresenter(this);
        presenter.loadAllRiders();
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.loadAllRiders();
    }


    private void inicialiceRiderList() {
        riderList = new ArrayList<>();
        ridersAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, riderList);
        ListView lvRiders = findViewById(R.id.rider_list);
        lvRiders.setAdapter(ridersAdapter);//aqui se emparejan

        registerForContextMenu(lvRiders);

    }


    @Override
    public void listAllRiders(List<Rider> riders) {
        riderList.clear();
        riderList.addAll(riders);
        ridersAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
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
//                Intent intent = new Intent(this, NewRiderView.class);
//                intent.putExtra("rider", ridersList.get(position));
//                intent.putExtra("ACTION" , "PUT");
//                startActivity(intent);
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