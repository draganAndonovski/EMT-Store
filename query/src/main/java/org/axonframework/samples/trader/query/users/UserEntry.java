package org.axonframework.samples.trader.query.users;

import org.axonframework.samples.trader.api.users.UserAccount;

import org.axonframework.samples.trader.query.order.OrderEntry;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document
public class
UserEntry implements UserAccount, Serializable {

    @Id
    private String identifier;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String username;
    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade =  CascadeType.ALL, targetEntity = LineItemEntry.class)
    private List<LineItemEntry> cart = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade =  CascadeType.ALL, targetEntity = OrderEntry.class)
    private List<OrderEntry> orders = new ArrayList<>();

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<LineItemEntry> getCart() { return cart; }

    public void setCart(List<LineItemEntry> cart) { this.cart = cart; }

    public List<OrderEntry> getOrders() { return orders; }

    public void setOrders(List<OrderEntry> orders) { this.orders = orders; }

    @Override
    public String getUserId() {
        return this.identifier;
    }

    @Override
    public String getUserName() {
        return this.username;
    }

    @Override
    public String getFullName() {
        return this.firstName+this.lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}