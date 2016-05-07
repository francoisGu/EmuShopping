package com.litaos.service;

import com.litaos.model.*;

import java.util.List;

/**
 * Created by litaoshen on 11/10/2015.
 */
public interface UserService {

    boolean login(String username, String password);

    boolean logout();

    User getCurrentUser();

    String getType(User user);

    Cart addToCart(User user, Product product);
    Cart removeFromCart(User user, Product product);

    Order createOrder();

    boolean cancelOrder(Buyer buyer, Order order);

    boolean approveCancelOrder(Order order);

    Order findOrderById(int id);

    int create(User user);

    boolean update(User user);

    List<Buyer> listAllBuyers();

    List<Order> listAllOrders();

    User findUserById(int id);

    User findUserByUsername(String username);

    List<Buyer> findBuyers(String key, String value);
}
