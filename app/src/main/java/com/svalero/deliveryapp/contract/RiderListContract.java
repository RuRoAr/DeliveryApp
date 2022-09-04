package com.svalero.deliveryapp.contract;


import com.svalero.deliveryapp.domain.Rider;

import java.util.List;

public interface RiderListContract {
    interface Model {

        interface OnLoadRidersListener {
            void onLoadRidersSuccess(List<Rider> riders);
            void onLoadRidersError(String message);
        }
      interface OnDeleteRiderListener {
        ;
        void onDeleteRiderSuccess();
        void onDeleteRiderError(String message);
    }

        void loadAllRiders(RiderListContract.Model.OnLoadRidersListener listener);
        void deleteRider(RiderListContract.Model.OnDeleteRiderListener listener, String riderId);
    }

    interface View {
        void listAllRiders(List<Rider> riders);
        void showErrorMessage(String message);
    }

    interface Presenter {
        void loadAllRiders();
        void deleteRider(String riderId);
    }
}
