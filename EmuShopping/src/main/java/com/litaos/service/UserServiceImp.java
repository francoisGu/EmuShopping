package com.litaos.service;

import com.litaos.mapper.ObjectMapper;
import com.litaos.mapper.ObjectRepository;
import com.litaos.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by litaoshen on 11/10/2015.
 */
public class UserServiceImp implements UserService {

    private User user;

    @Qualifier("objectMapper")
    @Autowired
    ObjectRepository objectRepository = new ObjectMapper();

    @Override
    public boolean login(String username, String password) {

        System.out.println("up - " + username + " " + password);
        User user = this.findUserByUsername(username);

//        System.out.println( "Login - " + user.getUsername() );

        if (user == null ||
                !password.equals(user.getPassword())) {
            return false;
        }

        this.user = user;

        return true;
    }

    @Override
    public boolean logout() {

        this.user = null;
        return true;
    }

    @Override
    public User getCurrentUser() {

        return this.user;
    }

    @Override
    public String getType(User user) {
        return user.getType();
    }

    @Override
    public Cart addToCart(User user, Product product) {

        if (user instanceof Buyer) {
            Buyer buyer = ((Buyer) user);

            Cart cart = buyer.getCart();
            if (cart == null) {

                cart = new Cart();
                buyer.setCart(cart);
                System.out.println("Create new cart");

            }
            buyer.getCart().addToProductList(product);

            String dest = buyer.getCart().getProductList().get(0).getDescription();
            System.out.println(dest);

            return ((Buyer) user).getCart();
        }

        return null;
    }

    @Override
    public Cart removeFromCart(User user, Product product) {
        Cart cart = null;
        if (user instanceof Buyer) {
            Buyer buyer = ((Buyer) user);

            cart = buyer.getCart();
            cart.getProductList().remove(product);
        }

        return cart;
    }

    @Override
    public Order createOrder() {
        Order order = new Order(Order.PAID);
        User currentUser = this.getCurrentUser();
        if (currentUser instanceof Buyer) {
            Cart cart = ((Buyer) currentUser).getCart();
            if (cart != null) {
                order.setProductList(cart.getProductList());
                order.setBuyer((Buyer) currentUser);
                objectRepository.create(order);

                ((Buyer) currentUser).getOrders().add(order);
                objectRepository.update(currentUser);

                ((Buyer) currentUser).setCart(new Cart());
            }

        }
        return order;
    }

    @Override
    public boolean cancelOrder(Buyer buyer, Order order) {

        boolean canceled = false;

        order.setStatus(Order.WAIT_TO_CANCEL);
        Optional<Order> optional = buyer.getOrders()
                .stream()
                .parallel()
                .filter(o -> o.getOrderId() == order.getOrderId())
                .findFirst();

        if (optional.isPresent()) {
            optional.get().setStatus(Order.WAIT_TO_CANCEL);
        }

        canceled = objectRepository.update(order);

        return canceled;
    }

    @Override
    public boolean approveCancelOrder(Order order) {
        boolean canceled = false;

        order.setStatus(Order.CANCELED);

        canceled = objectRepository.update(order);

        return canceled;
    }

    @Override
    public Order findOrderById(int id) {

        List<Object> objects = objectRepository
                .findByKey(Order.class, "orderId", id);

        Order order = (Order) objects.get(0);

        return order;
    }

    @Override
    public int create(User user) {
        return objectRepository.create(user);
    }

    @Override
    public boolean update(User user) {
        return objectRepository.update(user);
    }

    @Override
    public List<Buyer> listAllBuyers() {
        return objectRepository.listAll(Buyer.class);
    }

    @Override
    public List<Order> listAllOrders() {
        return objectRepository.listAll(Order.class);
    }

    @Override
    public User findUserById(int id) {

        List<Object> results = this.findByBuyerKey("userId", id);
        User user = null;

        if (results != null && results.size() > 0) {
            user = (User) results.get(0);
        }

        return user;
    }

    @Override
    public User findUserByUsername(String username) {

        List<Object> results = this.findByBuyerKey("username", username);
        User user = null;

        if (results != null && results.size() > 0) {
            user = (User) results.get(0);
        }

        return user;
    }

    @Override
    public List<Buyer> findBuyers(String key, String value) {

        List<Buyer> userList = new ArrayList<>();

        switch (key) {
            case "userId":
                try {
                    userList.add((Buyer) this.findUserById(Integer.parseInt(value)));
                } catch (NumberFormatException e) {

                }
                break;
            case "username":

                Stream<Buyer> stream = listAllBuyers().stream();
                Predicate<Buyer> pred = buyer ->
                        buyer.getUsername().contains(value);

                userList = stream
                        .parallel()
                        .filter(pred)
                        .collect(Collectors.toList());
                break;
            default:
                break;
        }

        return userList;
    }

    private List<Object> findByBuyerKey(String key, Object value) {
        return objectRepository.findByKey(User.class, key, value);
    }


    public List<User> findUsersByString(String key, String value) {

        List<User> resultList = new ArrayList<>();
        if (resultList.size() > 0) {

            resultList = this.findByBuyerKey(key, value)
                    .stream()
                    .map(object -> (Buyer) object)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        return resultList;
    }
}
