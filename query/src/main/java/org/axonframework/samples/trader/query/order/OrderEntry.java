package org.axonframework.samples.trader.query.order;

import org.axonframework.samples.trader.query.users.LineItemEntry;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Document
public class OrderEntry {

    @Id
    private String identifier;
    private String userId;

    private String shippingAddress;
    @OneToMany(fetch = FetchType.EAGER, cascade =  CascadeType.ALL, targetEntity = LineItemEntry.class)
    private List<LineItemEntry> lineItemEntryList = new ArrayList<>();

    @Embedded
    private OrderInfoDTOEntry orderInfoDTOEntry;

    public String getIdentifier() {
        return identifier;
    }

    void setIdentifier(String identifier) {
        this.identifier = identifier;
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