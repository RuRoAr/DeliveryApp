package com.svalero.deliveryapp.contract;

import com.svalero.deliveryapp.domain.Order;
import com.svalero.deliveryapp.domain.Restaurant;

public interface NewOrderContract {

    interface Model {

        interface OnAddOrderListener {
            void onAddOrderSuccess(Order newOrder);
            void onAddOrderError(String message);
        }
        void addOrder(Order order, OnAddOrderListener listener);

        interface OnModifyOrderListener {
            void onModifyOrderSuccess(Order newOrder);
            void onModifyOrderError(String message);
        }
        void modifyOrder(long orderId, Order order, OnModifyOrderListener listener);


    }

    interface View {

    void addOrder(android.view.View view);
    void showMessage(String message);

    }

    interface Presenter {
    void addOrder( String price, String weight, boolean ready, String time, String distance);
    void modifyOrder( long orderId,String price, String weight, boolean ready, String time, String distance);


    }
}
