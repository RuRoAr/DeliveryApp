package com.svalero.deliveryapp.presenter;

import com.svalero.deliveryapp.contract.NewOrderContract;
import com.svalero.deliveryapp.domain.Order;

import com.svalero.deliveryapp.model.NewOrderModel;

import com.svalero.deliveryapp.view.NewOrderView;


public class NewOrderPresenter implements NewOrderContract.Presenter, NewOrderContract.Model.OnAddOrderListener, NewOrderContract.Model.OnModifyOrderListener {

    private NewOrderModel model;
    private NewOrderView view;

    public NewOrderPresenter(NewOrderView view){
        this.view = view;
        model = new NewOrderModel(view.getApplicationContext());
    }


    @Override
    public void addOrder( String price, String weight, boolean ready, String time, String distance) {

        if (!validData( price,  weight,  ready,  time, distance))
            view.showMessage("Error al validar la informacion");
        Order order = new Order( Long.parseLong(price),  Float.parseFloat(weight), ready,  Integer.parseInt(time), Integer.parseInt( distance));
        model.addOrder(order,this);


    }


    private  boolean validData( String price, String weight, boolean ready, String time, String distance){
        if (price.equals("")) {
            return false;
        }

        if (weight.equals(""))
            weight = "1";

        if (time.equals(""))
            time = "0";
        return true;
    }

    @Override
    public void onAddOrderSuccess(Order order) {
        view.showMessage("ok");
    }

    @Override
    public void onAddOrderError(String message) {
        view.showMessage("error");
    }

    @Override
    public void modifyOrder(String orderId, String price, String weight, boolean ready, String time, String distance) {
        if (!validData( price,  weight,  ready,  time, distance))
            view.showMessage("Error al validar la informacion");

        Order order = new Order(Long.parseLong(price),  Float.parseFloat(weight), ready,  Integer.parseInt(time), Integer.parseInt( distance));
        order.setId(orderId);
        model.modifyOrder(orderId , order, this);


    }





    @Override
    public void onModifyOrderSuccess(Order newOrder) {
        view.showMessage("ok");
    }

    @Override
    public void onModifyOrderError(String message) {
        view.showMessage("error");
    }


}
