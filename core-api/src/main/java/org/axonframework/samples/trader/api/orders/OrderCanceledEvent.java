package org.axonframework.samples.trader.api.orders;

import org.axonframework.samples.trader.api.orders.trades.OrderId;
import org.axonframework.samples.trader.api.users.UserId;

import java.util.List;

/**
 * Created by DELL-PC on 7/3/2016.
 */
public class OrderCanceledEvent {

    private OrderId orderId;

    public OrderCanceledEvent(OrderId orderId) {
        this.orderId = orderId;
    }

    public OrderId getOrderId() { return orderId; }
}
