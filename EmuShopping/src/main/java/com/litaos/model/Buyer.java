package com.litaos.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by litaoshen on 9/09/2015.
 */
public class Buyer extends User {

    Set<Order> orders = new HashSet<>();
    Cart cart;

    public Buyer(String username, String password, String role) {
        super(username, password, role);
    }

    public Buyer() {
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
