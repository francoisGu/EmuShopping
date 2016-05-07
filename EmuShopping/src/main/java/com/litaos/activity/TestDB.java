package com.litaos.activity;

import com.litaos.mapper.ObjectMapper;
import com.litaos.mapper.ObjectRepository;
import com.litaos.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by litaoshen on 9/09/2015.
 */
public class TestDB {

    public static void main(String[] args) {

        ObjectRepository objectRepository = new ObjectMapper();

        testUser(objectRepository);

        testProduct(objectRepository);

    }

    public static void seedData(ObjectRepository objectRepository) {
        testProduct(objectRepository);
        testUser(objectRepository);
    }

    public static void testUser(ObjectRepository objectRepository) {

        Buyer buyer1 = new Buyer("tom", "tom", User.BUYER);
//        buyer1.setCredit( 10 );
        Buyer buyer2 = new Buyer("ben", "ben", User.BUYER);
        Buyer buyer3 = new Buyer("jack", "jack", User.BUYER);
        Seller seller1 = new Seller("seller", "seller", User.SELLER);

        int user1 = objectRepository.create(buyer1);
        int user2 = objectRepository.create(buyer2);
        int user3 = objectRepository.create(buyer3);
        int user4 = objectRepository.create(seller1);

        // list all buyers
        List<Buyer> buyers = objectRepository.listAll(Buyer.class);
        buyers.forEach(buyer -> System.out.println("Buyer ID : " + buyer.getUserId()));

        // list all sellers
        List<Seller> sellers = objectRepository.listAll(Seller.class);
        sellers.forEach(seller -> System.out.println("Seller ID : " + seller.getUserId()));

        // update buyer1
        buyer1.setPassword("12345");
        objectRepository.update(buyer1);

        // delete buyer2
//        objectRepository.delete(buyer2);

        // list all users
        List<User> users = objectRepository.listAll(User.class);
        users.forEach(user -> System.out.println("User name: " + user.getUsername()));

        List<User> nothing = objectRepository.listAll(null);

        // find user by username
        User user = (User) objectRepository.findByKey(User.class, "username", "tom").get(0);
        System.out.println("User: find by key " + user.getUsername());
    }

    public static void testProduct(ObjectRepository objectRepository) {
        Product product1 = new Product("vitaminC", "good for A", 101.00, 10);
        Product product2 = new Product("vitaminD", "good for B", 101.00, 10);
        Product product3 = new Product("vitaminE", "good for C", 101.00, 10);
        Product product4 = new Product("vitaminF", "good for D", 101.00, 10);
        Product product5 = new Product("Men's ultivte", "Swisse Men’s Ultivite is a premium quality formula, containing 53 vitamins, minerals, antioxidants and herbs tailored for men to help maintain energy levels, mental alertness, provide support during stress and assist with stamina and vitality.", 101.00, 10);


        int pId1 = objectRepository.create(product1);
        int pId2 = objectRepository.create(product2);
        int pId3 = objectRepository.create(product3);
        int pId4 = objectRepository.create(product4);
        int pId5 = objectRepository.create(product5);


        Buyer buyer1 = new Buyer("toming", "tomason", User.BUYER);
        int user1 = objectRepository.create(buyer1);

        List<Product> productSet = new ArrayList<>();
        productSet.add(product1);
        productSet.add(product2);

        Order order = new Order(Order.PAID);
        order.getProductList().addAll( productSet );
        order.setBuyer(buyer1);

        objectRepository.create( order );

        buyer1.getOrders().add( order );

        objectRepository.update(buyer1);

        // list all products
        List<Product> products = objectRepository.listAll(Product.class);
        products.forEach(product -> System.out.println(product.getProductName()));

        // update product 1
        product1.setQuantity(102);
        objectRepository.update(product1);

        // delete product 2
//        objectRepository.delete(product2);

        // find product by name
        Product product = (Product)
                objectRepository.findByKey(Product.class,
                        "productName",
                        product1.getProductName())
                        .get(0);
        System.out.println("Product: find by key " + product.getDescription());

    }
}
