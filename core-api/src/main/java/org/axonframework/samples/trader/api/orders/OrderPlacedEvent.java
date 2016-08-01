package org.axonframework.samples.trader.api.orders;

import org.axonframework.samples.trader.api.orders.trades.OrderId;
import org.axonframework.samples.trader.api.users.UserId;

import java.util.List;

/**
 * Created by DELL-PC on 7/3/2016.
 */
public class OrderPlacedEvent {

    private OrderId orderId;
    private UserId userId;
    private String shippingAddress;
    private List<LineItem> lineItemList;

    public OrderPlacedEvent(OrderId orderId, UserId userId, String shippingAddress, List<LineItem> lineItemList) {
        this.orderId = orderId;
        this.userId = userId;
        this.shippingAddress = shippingAddress;
        this.lineItemList = lineItemList;
    }

    public OrderId getOrderId() { return orderId; }

    public UserId getUserId() { return userId; }

    public List<LineItem> getLineItemList() { return lineItemList; }

    public String getShippingAddress() { return shippingAddress; }
}
