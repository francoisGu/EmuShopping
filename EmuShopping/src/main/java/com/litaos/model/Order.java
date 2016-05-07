package com.litaos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by litaoshen on 11/10/2015.
 */
public class Order implements Serializable{

    public static final String PAID = "paid";
    public static final String WAIT_TO_CANCEL = "wait_to_cancel";
    public static final String CANCELED = "canceled";

    static final long serialVersionUID = 1L;

    private int orderId;
    private String status;
    private List<Product> productList = new ArrayList<>();

    private Buyer buyer;

    public Order() {
    }

    public Order(String status) {
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", status=" + status +
                ", productList=" + productList +
                '}';
    }
}
