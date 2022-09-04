package com.svalero.deliveryapp.contract;

import com.svalero.deliveryapp.domain.Rider;

public interface NewRiderContract {
    interface Model {

        interface OnAddRiderListener {
            void onAddRiderSuccess(Rider newRider);
            void onAddRiderError(String message);
        }
        void addRider(Rider rider, NewRiderContract.Model.OnAddRiderListener listener);

        interface OnModifyRiderListener {
            void onModifyRiderSuccess(Rider newOrder);
            void onModifyRiderError(String message);
        }
        void modifyRider(long orderId, Rider rider, NewRiderContract.Model.OnModifyRiderListener listener);


    }

    interface View {

        void addRider(android.view.View view);
        void showMessage(String message);

    }

    interface Presenter {
        void addRider(String dni, String name, String surname, String vehicle, int maxSpeed);
        void modifyRider(long riderId,String dni, String name, String surname, String vehicle, int maxSpeed);
    }
}
