package com.svalero.deliveryapp.presenter;


import com.svalero.deliveryapp.contract.NewRiderContract;
import com.svalero.deliveryapp.domain.Rider;

import com.svalero.deliveryapp.model.NewRiderModel;

import com.svalero.deliveryapp.view.NewRiderView;

public class NewRiderPresenter implements NewRiderContract.Presenter,
        NewRiderContract.Model.OnAddRiderListener,
        NewRiderContract.Model.OnModifyRiderListener {
    private NewRiderModel model;
    private NewRiderView view;

    public NewRiderPresenter(NewRiderView view){
        this.view = view;
        model = new NewRiderModel(view.getApplicationContext());
    }


    @Override
    public void addRider(  String dni,String name, String surname, String vehicle, int maxSpeed) {
        if (!validData( dni, name,  surname, vehicle,  maxSpeed))
            view.showMessage("Error al validar la informacion");
        Rider rider = new Rider( dni,name, surname, vehicle,  Integer.parseInt(String.valueOf(maxSpeed)));
        model.addRider(rider,this);
    }
    private  boolean validData( String dni, String name, String surname, String vehicle, int maxSpeed){
        if (name.equals("")) {
            return false;
        }

        if (surname.equals(""))
            surname = "";

        if (vehicle.equals(""))
            vehicle = "";
        return true;
    }

    @Override
    public void onAddRiderSuccess(Rider rider) {
        view.showMessage("ok");
    }

    @Override
    public void onAddRiderError(String message) {
        view.showMessage("error");
    }

    @Override
    public void modifyRider(long riderId, String dni,String name, String surname, String vehicle, int maxSpeed) {
        if (!validData( dni, name,  surname, vehicle,  maxSpeed))
            view.showMessage("Error al validar la informacion");
        Rider rider = new Rider( dni, name,  surname,  vehicle, Integer.parseInt(String.valueOf(maxSpeed)));
        rider.setId(riderId);
        model.modifyRider(riderId , rider, this);
    }
    @Override
    public void onModifyRiderSuccess(Rider newRider) {
        view.showMessage("ok");
    }

    @Override
    public void onModifyRiderError(String message) {
        view.showMessage("error");
    }

}
