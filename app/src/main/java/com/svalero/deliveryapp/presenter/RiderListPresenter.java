package com.svalero.deliveryapp.presenter;

import com.svalero.deliveryapp.contract.RiderListContract;
import com.svalero.deliveryapp.domain.Order;
import com.svalero.deliveryapp.domain.Rider;
import com.svalero.deliveryapp.model.OrderListModel;
import com.svalero.deliveryapp.model.RiderListModel;
import com.svalero.deliveryapp.view.OrderListView;
import com.svalero.deliveryapp.view.RiderListView;

import java.util.List;

public class RiderListPresenter implements RiderListContract.Presenter,
        RiderListContract.Model.OnLoadRidersListener {

    private RiderListView view;
    private RiderListModel model;

    public RiderListPresenter(RiderListView view) {
    model = new RiderListModel(view.getApplicationContext());
        this.view = view;
    }


    @Override
    public void loadAllRiders() {
        model.loadAllRiders(this);
    }

    @Override
    public void onLoadRidersSuccess(List<Rider> riders) {
        view.listAllRiders(riders);
    }

    @Override
    public void onLoadRidersError(String message) {
        view.showErrorMessage(message);

    }
}
