package com.svalero.deliveryapp.contract;

import com.svalero.deliveryapp.domain.Order;
import com.svalero.deliveryapp.domain.Restaurant;

import java.util.List;

public interface OrderListContract {

    interface Model {
        interface OnLoadOrdersListener {
            void onLoadOrdersSuccess(List<Order> restaurants);
            void onLoadOrdersError(String message);
        }
        void loadAllOrders(OnLoadOrdersListener listener);
    }

    interface View {
        void listAllOrders(List<Order> orders);
        void showErrorMessage(String message);
    }

    interface Presenter {
        void loadAllOrders();
    }
}

