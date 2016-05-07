package com.litaos.model;


import java.io.Serializable;
import java.util.Objects;

/**
 * Created by litaoshen on 9/09/2015.
 */
public class Product implements Serializable{

    static final long serialVersionUID = 1L;

    private int productId;
    private String productName;
    private String description;
    private double productPrice;
    private int quantity;

    public Product() {
    }

    public Product(String productName, String description, double productPrice, int quantity) {
        this.productName = productName;
        this.description = description;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + productId + '\'' +
                "productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", productPrice=" + productPrice +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Product product = (Product) object;
        return Objects.equals(productId, product.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
