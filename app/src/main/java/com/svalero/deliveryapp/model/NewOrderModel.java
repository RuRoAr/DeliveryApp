package com.svalero.deliveryapp.model;

import android.content.Context;

import com.svalero.deliveryapp.api.DeliveryApi;
import com.svalero.deliveryapp.api.DeliveryApiInterface;
import com.svalero.deliveryapp.contract.NewOrderContract;
import com.svalero.deliveryapp.domain.Order;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewOrderModel implements NewOrderContract.Model {
    private Context context;
    public NewOrderModel(Context context){
        this.context = context;
    }


    @Override
    public void addOrder(Order order, OnAddOrderListener listener) {

        DeliveryApiInterface api = DeliveryApi.buildInstance();
        Call<Order> callOrders = api.addOrder(order);

        callOrders.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                Order orders = response.body();
                listener.onAddOrderSuccess(orders);
            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                listener.onAddOrderError("Se ha producido un error");
                t.printStackTrace();
            }
        });
    }

    @Override
    public void modifyOrder(String orderId, Order order, OnModifyOrderListener listener) {
        DeliveryApiInterface api = DeliveryApi.buildInstance();
        Call<Order> callOrders = api.modifyOrder(orderId, order);

        callOrders.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                Order orders = response.body();
                listener.onModifyOrderSuccess(orders);
            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                listener.onModifyOrderError("Se ha producido un error");
                t.printStackTrace();
            }
        });
    }


}
