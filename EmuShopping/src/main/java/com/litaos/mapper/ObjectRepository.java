package com.litaos.mapper;

import java.util.List;

/**
 * Created by litaoshen on 10/09/2015.
 */
public interface ObjectRepository {

//    public Product create(String productName, String description, double productPrice, int quantity);

    // return int type object ID when create successfully.
    int create(Object object);

    // return true when update successfully.
    boolean update(Object object);

    // return true when delete successfully.
    boolean delete(Object object);

    // find by key and value.
    List<Object> findByKey(Class objectClass, String key, Object value);

    // list all
    List listAll(Class objectClass);
}
