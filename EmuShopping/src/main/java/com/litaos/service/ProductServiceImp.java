package com.litaos.service;

import com.litaos.mapper.ObjectMapper;
import com.litaos.mapper.ObjectRepository;
import com.litaos.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by litaoshen on 10/09/2015.
 */
public class ProductServiceImp implements ProductService{

    Product product;

    @Qualifier("objectMapper")
    @Autowired
    ObjectRepository objectRepository = new ObjectMapper();

    @Override
    public int create(Product product) {
        return objectRepository.create(product);
    }

    @Override
    public boolean update(Product product) {
        return objectRepository.update(product);
    }

    @Override
    public boolean delete(Product product) {
        return objectRepository.delete(product);
    }

    @Override
    public Product findById(int id) {
        return (Product) this.findByKey("productId", id).get(0);
    }

    @Override
    public Product findByName(String name) {
        return (Product) this.findByKey("productName", name).get(0);
    }

    @Override
    public List<Product> findProducts(String key, String value) {
        List<Product> productList = new ArrayList<>();

        switch (key){
            case "productId":

                try {
                    productList.add(this.findById(Integer.parseInt(value)));
                } catch (NumberFormatException e){

                }

                break;

            case "productName":

            case "description":

                Stream<Product> stream = listAll().stream();
                Predicate<Product> pred = product ->
                        product.getDescription().toLowerCase().contains(value.toLowerCase()) ||
                                product.getProductName().toLowerCase().contains(value.toLowerCase());

                productList = stream
                        .parallel()
                        .filter(pred)
                        .collect(Collectors.toList());
                break;
            default:
                break;
        }

        return productList;
    }

    @Override
    public List<Product> listAll() {
        return objectRepository.listAll(Product.class);
    }

    public List<Object> findByKey(String key, Object value) {
        return objectRepository.findByKey(Product.class, key, value);
    }

    public List<Product> findProductsByString( String key, String value){

        List<Product> resultList = new ArrayList<>();
        if( resultList.size() > 0){

            resultList= this.findByKey(key, value)
                    .stream()
                    .map(object -> (Product) object)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        return resultList;
    }
}
