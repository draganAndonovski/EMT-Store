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

package org.axonframework.samples.trader.query.orderbook;

import org.axonframework.samples.trader.query.users.LineItemEntry;
import org.axonframework.samples.trader.query.users.UserEntry;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jettro Coenradie
 */
@Entity
public class OrderEntry {

    @javax.persistence.Id
    @GeneratedValue
    private Long jpaId;

    private String identifier;

    private String shippingAddress;
    @OneToMany(fetch = FetchType.EAGER, cascade =  CascadeType.ALL, targetEntity = LineItemEntry.class)
    private List<LineItemEntry> lineItemEntryList = new ArrayList<LineItemEntry>();

    @Embedded
    private OrderInfoDTOEntry orderInfoDTOEntry;
    String userId;
    private long tradeCount;
    private long itemPrice;
    private long itemsRemaining;
    private String type;

    //@ManyToOne
    //private UserEntry userEntry;

    public String getIdentifier() {
        return identifier;
    }

    void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public long getItemPrice() {
        return itemPrice;
    }

    void setItemPrice(long itemPrice) {
        this.itemPrice = itemPrice;
    }

    public long getItemsRemaining() {
        return itemsRemaining;
    }

    void setItemsRemaining(long itemsRemaining) {
        this.itemsRemaining = itemsRemaining;
    }

    public long getTradeCount() {
        return tradeCount;
    }

    void setTradeCount(long tradeCount) {
        this.tradeCount = tradeCount;
    }

    public String getType() {
        return type;
    }

    void setType(String type) {
        this.type = type;
    }

    public Long getJpaId() {
        return jpaId;
    }

    public void setJpaId(Long jpaId) {
        this.jpaId = jpaId;
    }

    public String getShippingAddress() { return shippingAddress; }

    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }

    public List<LineItemEntry> getLineItemEntryList() { return lineItemEntryList; }

    public void setLineItemEntryList(List<LineItemEntry> lineItemEntryList) { this.lineItemEntryList = lineItemEntryList; }

    public OrderInfoDTOEntry getOrderInfoDTOEntry() { return orderInfoDTOEntry; }

    public void setOrderInfoDTOEntry(OrderInfoDTOEntry orderInfoDTOEntry) { this.orderInfoDTOEntry = orderInfoDTOEntry; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }
}
