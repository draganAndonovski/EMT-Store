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

package org.axonframework.samples.trader.query.users;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.samples.trader.api.orders.LineItem;
import org.axonframework.samples.trader.api.orders.OrderCompletedEvent;
import org.axonframework.samples.trader.api.orders.OrderInfoDTO;
import org.axonframework.samples.trader.api.users.LineItemAddedToCartEvent;
import org.axonframework.samples.trader.api.users.LineItemQtyInCartUpdatedEvent;
import org.axonframework.samples.trader.api.users.LineItemRemovedFromCartEvent;
import org.axonframework.samples.trader.query.orderbook.OrderEntry;
import org.axonframework.samples.trader.query.orderbook.OrderInfoDTOEntry;
import org.axonframework.samples.trader.query.users.repositories.UserQueryRepository;
import org.axonframework.samples.trader.api.users.UserCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jettro Coenradie
 */
@Component
public class UserListener {

    private UserQueryRepository userRepository;

    @EventHandler
    public void handleUserCreated(UserCreatedEvent event) {
        UserEntry userEntry = new UserEntry();
        userEntry.setIdentifier(event.getUserIdentifier().toString());
        userEntry.setFirstName(event.getFirstName());
        userEntry.setLastName(event.getLastName());
        userEntry.setEmail(event.getEmail());
        userEntry.setPhone(event.getPhone());
        userEntry.setUsername(event.getUsername());
        userEntry.setPassword(event.getPassword());

        userRepository.save(userEntry);
    }

    /**
     *
     * @author Dragan Andonovski
     */
    @EventHandler
    public void handleLineItemAddedToCart(LineItemAddedToCartEvent event) {
        UserEntry userEntry = userRepository.findByIdentifier(event.getUserId().toString());

        LineItemEntry lineItemEntry = new LineItemEntry();
        lineItemEntry.setProductId(event.getProductId().toString());
        lineItemEntry.setProductQuantity(event.getProductQuantity());
        userEntry.getCart().add(lineItemEntry);

        userRepository.save(userEntry);
    }

    @EventHandler
    public void handleLineItemRemovedFromCart(LineItemRemovedFromCartEvent event) {
        UserEntry userEntry = userRepository.findByIdentifier(event.getUserId().toString());

        List<LineItemEntry> cart = userEntry.getCart();
        int index = -1;

        for(int i = 0; i<cart.size(); i++) {
            LineItemEntry lineItemEntry = cart.get(i);
            if(lineItemEntry.getProductId().equals(event.getProductId().toString())) {
                index = i;
                break;
            }
        }

        if(index!=-1)
            cart.remove(index);

        userRepository.save(userEntry);
    }

    @EventHandler
    public void handleLineItemQtyInCartUpdated(LineItemQtyInCartUpdatedEvent event) {
        UserEntry userEntry = userRepository.findByIdentifier(event.getUserId().toString());

        List<LineItemEntry> cart = userEntry.getCart();
        int index = -1;

        for(int i = 0; i<cart.size(); i++) {
            LineItemEntry lineItemEntry = cart.get(i);
            if(lineItemEntry.getProductId().equals(event.getProductId().toString())) {
                index = i;
                break;
            }
        }

        if(index!=-1)
            cart.get(index).setProductQuantity(event.getProductQuantity());

        userRepository.save(userEntry);
    }

    @EventHandler
    public void handleOrderCompleted(OrderCompletedEvent event) {
        UserEntry userEntry = userRepository.findByIdentifier(event.getUserId().toString());
        //TODO Add OrderEntry in UserEntry and save.
        OrderEntry orderEntry = new OrderEntry();

        List<LineItemEntry> lineItemEntryList = new ArrayList<>();
        for(LineItem lineItem : event.getLineItemList()) {
            LineItemEntry lineItemEntry = new LineItemEntry();
            lineItemEntry.setProductId(lineItem.getProductId().toString());
            lineItemEntry.setProductQuantity(lineItem.getProductQuantity());
            lineItemEntryList.add(lineItemEntry);
        }
        orderEntry.setLineItemEntryList(lineItemEntryList);
        orderEntry.setOrderInfoDTOEntry(this.createOrderInfoDTOEntry(event.getOrderInfoDTO()));
        orderEntry.setUserId(event.getUserId().toString());

        userEntry.getOrders().add(orderEntry);
        userRepository.save(userEntry);

        System.out.println("THE USER HAS ORDERED " +userEntry.getOrders().size() +" TIMES");
        for(OrderEntry orderEntry1 : userEntry.getOrders()) {
            System.out.println(orderEntry1);
        }

        System.out.println("ORDER COMPLETED HANDLED");
    }

    private OrderInfoDTOEntry createOrderInfoDTOEntry(OrderInfoDTO orderInfoDTO) {
        OrderInfoDTOEntry orderInfoDTOEntry = new OrderInfoDTOEntry();
        orderInfoDTOEntry.setEmail(orderInfoDTO.getEmail());
        orderInfoDTOEntry.setPayerId(orderInfoDTO.getPayerId());
        orderInfoDTOEntry.setFirstName(orderInfoDTO.getFirstName());
        orderInfoDTOEntry.setLastName(orderInfoDTO.getLastName());
        orderInfoDTOEntry.setCntryCode(orderInfoDTO.getCntryCode());
        orderInfoDTOEntry.setShipToName(orderInfoDTO.getShipToName());
        orderInfoDTOEntry.setShipToStreet(orderInfoDTO.getShipToStreet());
        orderInfoDTOEntry.setShipToCity(orderInfoDTO.getShipToCity());
        orderInfoDTOEntry.setShipToState(orderInfoDTO.getShipToState());
        orderInfoDTOEntry.setShipToCntryCode(orderInfoDTO.getShipToCntryCode());
        orderInfoDTOEntry.setShipToZip(orderInfoDTO.getShipToZip());
        return orderInfoDTOEntry;
    }

    @Autowired
    public void setUserRepository(UserQueryRepository userRepository) {
        this.userRepository = userRepository;
    }
}
