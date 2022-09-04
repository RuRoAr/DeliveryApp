package com.svalero.deliveryapp.model;

import android.content.Context;

import com.svalero.deliveryapp.api.DeliveryApi;
import com.svalero.deliveryapp.api.DeliveryApiInterface;
import com.svalero.deliveryapp.contract.NewRiderContract;
import com.svalero.deliveryapp.domain.Rider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewRiderModel implements NewRiderContract.Model {
    private Context context;

    public NewRiderModel(Context context){
        this.context = context;
    }
    @Override
    public void addRider(Rider rider, NewRiderContract.Model.OnAddRiderListener listener) {
        DeliveryApiInterface api = DeliveryApi.buildInstance();
        Call<Rider> callRiders = api.addRider(rider);
        callRiders.enqueue(new Callback<Rider>() {
            @Override
            public void onResponse(Call<Rider> call, Response<Rider> response) {
                Rider riders = response.body();
                listener.onAddRiderSuccess(riders);
            }
            @Override
            public void onFailure(Call<Rider> call, Throwable t) {
                listener.onAddRiderError("Se ha producido un error");
                t.printStackTrace();
            }
        });
    }
    @Override
    public void modifyRider(long riderId, Rider rider, NewRiderContract.Model.OnModifyRiderListener listener) {
        DeliveryApiInterface api = DeliveryApi.buildInstance();
        Call<Rider> callRiders = api.modifyRider(riderId, rider);
        callRiders.enqueue(new Callback<Rider>() {
            @Override
            public void onResponse(Call<Rider> call, Response<Rider> response) {
                Rider riders = response.body();
                listener.onModifyRiderSuccess(riders);
            }
            @Override
            public void onFailure(Call<Rider> call, Throwable t) {
                listener.onModifyRiderError("Se ha producido un error");
                t.printStackTrace();
            }
        });
    }

}
