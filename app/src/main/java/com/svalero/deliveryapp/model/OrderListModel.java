package com.svalero.deliveryapp.model;

import android.content.Context;

import com.svalero.deliveryapp.api.DeliveryApi;
import com.svalero.deliveryapp.api.DeliveryApiInterface;
import com.svalero.deliveryapp.contract.OrderListContract;
import com.svalero.deliveryapp.contract.RestaurantListContract;
import com.svalero.deliveryapp.domain.Order;
import com.svalero.deliveryapp.domain.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderListModel implements OrderListContract.Model {
    private Context context;

    public OrderListModel(Context context){
        this.context = context;
    }

    @Override
    public void loadAllOrders(OrderListContract.Model.OnLoadOrdersListener listener) {



        DeliveryApiInterface api = DeliveryApi.buildInstance();
        Call<List<Order>> callOrders = api.getOrders();

        callOrders.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                List<Order> orders = response.body();
                listener.onLoadOrdersSuccess(orders);
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                listener.onLoadOrdersError("Se ha producido un error");
                t.printStackTrace();
            }
        });

    }
}
