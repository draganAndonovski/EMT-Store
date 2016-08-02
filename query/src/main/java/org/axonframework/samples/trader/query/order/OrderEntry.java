package org.axonframework.samples.trader.query.order;

import org.axonframework.samples.trader.query.users.LineItemEntry;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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