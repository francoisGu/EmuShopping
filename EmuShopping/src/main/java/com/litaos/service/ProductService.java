package com.litaos.service;

import com.litaos.model.Product;

import java.util.List;

/**
 * Created by litaoshen on 10/09/2015.
 */
public interface ProductService {

    // return int type object ID when create successfully.
    int create(Product product);

    // return true when update successfully.
    boolean update(Product product);

    // return true when delete successfully.
    boolean delete(Product product);

    // find by id
    Product findById(int id);

    // find by name
    Product findByName(String name);

    // find list of product by key
    List<Product> findProducts(String key, String value);

    // list all
    List listAll();

    // get product instance
}
