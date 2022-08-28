package com.svalero.deliveryapp.presenter;

import com.svalero.deliveryapp.contract.OrderListContract;
import com.svalero.deliveryapp.domain.Order;

import com.svalero.deliveryapp.model.OrderListModel;

import com.svalero.deliveryapp.view.OrderListView;


import java.util.List;

public class OrderListPresenter implements OrderListContract.Presenter, OrderListContract.Model.OnLoadOrdersListener {
    private OrderListView view;
    private OrderListModel model;

    public OrderListPresenter(OrderListView view) {
        model = new OrderListModel(view.getApplicationContext());
        this.view = view;
    }

    @Override
    public void loadAllOrders() {
        model.loadAllOrders(this);
    }

    @Override
    public void onLoadOrdersSuccess(List<Order> orders) {
        view.listAllOrders(orders);
    }

    @Override
    public void onLoadOrdersError(String message) {
        view.showErrorMessage(message);

    }
}
