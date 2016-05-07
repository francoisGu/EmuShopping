package com.litaos.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by litaoshen on 12/10/2015.
 */
public class Cart {

    private int cartId;
    private List<Product> productList = new ArrayList<>();


    public Cart(List<Product> productList) {
        this.productList = productList;
    }

    public Cart() {
    }

    public List<Product> addToProductList( Product product ){

        this.productList.add(product);

        return this.productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getCartId() {
        return cartId;
    }


}
