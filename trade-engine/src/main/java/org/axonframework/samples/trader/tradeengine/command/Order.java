/*
 * Copyright (c) 2010-2012. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.axonframework.samples.trader.tradeengine.command;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedEntity;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.samples.trader.api.orders.*;
import org.axonframework.samples.trader.api.orders.trades.OrderId;
import org.axonframework.samples.trader.api.orders.trades.PortfolioId;
import org.axonframework.samples.trader.api.orders.trades.TradeExecutedEvent;
import org.axonframework.samples.trader.api.orders.trades.TransactionId;
import org.axonframework.samples.trader.api.users.UserId;

import java.util.List;

/**
 * @author Allard Buijze
 */
class Order extends AbstractAnnotatedAggregateRoot {

    private static final long serialVersionUID = 8723320580785213954L;

    @AggregateIdentifier
    private OrderId orderId;

    private TransactionId transactionId;
    private final long itemPrice=0;
    private final long tradeCount=0;
    private final PortfolioId portfolioId=new PortfolioId();
    private long itemsRemaining;

    protected Order() {}

    public Order(OrderId orderId, UserId userId, String shippingAddress, List<LineItem> lineItemList) {
        apply(new OrderPlacedEvent(orderId, userId, shippingAddress, lineItemList));
    }

    public void completeOrder(OrderId orderId, UserId userId, OrderInfoDTO orderInfoDTO, List<LineItem> lineItemList) {
        apply(new OrderCompletedEvent(orderId, userId, orderInfoDTO, lineItemList));
    }

    public void confirmPayment(OrderId orderId, OrderInfoDTO orderInfoDTO) {
        System.out.println("Payment Confirmed in aggregate");
        apply(new PaymentConfirmedEvent(orderId, orderInfoDTO));
    }

    public long getItemPrice() {
        return itemPrice;
    }

    public long getTradeCount() {
        return tradeCount;
    }

    public PortfolioId getPortfolioId() {
        return portfolioId;
    }

    public long getItemsRemaining() {
        return itemsRemaining;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    private void recordTraded(long tradeCount) {
        this.itemsRemaining -= tradeCount;
    }

    public TransactionId getTransactionId() {
        return transactionId;
    }

    @EventHandler
    protected void onTradeExecuted(TradeExecutedEvent event) {
        if (orderId.equals(event.getBuyOrderId())
                || orderId.equals(event.getSellOrderId())) {
            recordTraded(event.getTradeCount());
        }
    }

    @EventHandler
    public void handle(OrderPlacedEvent event){
        this.orderId = event.getOrderId();
    }
}
