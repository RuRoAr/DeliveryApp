package com.svalero.deliveryapp.model;

import android.content.Context;

import com.svalero.deliveryapp.api.DeliveryApi;
import com.svalero.deliveryapp.api.DeliveryApiInterface;
import com.svalero.deliveryapp.contract.RiderListContract;

import com.svalero.deliveryapp.domain.Rider;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RiderListModel implements RiderListContract.Model {
    private Context context;

    public RiderListModel(Context context){
        this.context = context;
    }

    @Override
    public void loadAllRiders(RiderListContract.Model.OnLoadRidersListener listener) {
        DeliveryApiInterface api = DeliveryApi.buildInstance();
        Call<List<Rider>> callRiders = api.getRiders();

        callRiders.enqueue(new Callback<List<Rider>>() {
            @Override
            public void onResponse(Call<List<Rider>> call, Response<List<Rider>> response) {
                List<Rider> riders = response.body();
                listener.onLoadRidersSuccess(riders);
            }

            @Override
            public void onFailure(Call<List<Rider>> call, Throwable t) {
                listener.onLoadRidersError("Se ha producido un error");
                t.printStackTrace();
            }
        });
    }
}
