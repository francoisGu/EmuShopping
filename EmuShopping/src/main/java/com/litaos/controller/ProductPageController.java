package com.litaos.controller;

import com.litaos.model.*;
import com.litaos.service.ProductService;
import com.litaos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by litaoshen on 10/09/2015.
 */
@Controller
@RequestMapping("/product")
public class ProductPageController {

    @Qualifier("productServiceImp")
    @Autowired
    ProductService productService;

    @Qualifier("userServiceImp")
    @Autowired
    UserService userService;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newProduct(ModelMap model) {
//        return new ModelAndView("productCreation", "command", new Product());

        // pass empty product model to form
        model.addAttribute("command", new Product());
        // open page
        model.addAttribute("content", "productCreation.jsp");

        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createProduct(@ModelAttribute("SpringWeb") Product product,
                                ModelMap model) {

        productService.create(product);

        return "redirect:/product/list";
    }

    @RequestMapping(value = "{id}/read", method = RequestMethod.GET)
    public String showProduct(@PathVariable("id") int id,
                              ModelMap model) {

        // find product by id via productService
        Product product = productService.findById(id);

        model.addAttribute("productForm", product);

        // open page with page content product edit
        model.addAttribute("content", "productRead.jsp");
        return "index";
    }

    @RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
    public String showEditProduct(@PathVariable("id") int id,
                                  ModelMap model) {

        // find product by id via productService
        Product product = productService.findById(id);

        model.addAttribute("productForm", product);

        // open page with page content product edit
        model.addAttribute("content", "productEdit.jsp");
        return "index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateProduct(@ModelAttribute("productForm") Product product,
                                ModelMap model) {

        System.out.println(product.toString());

        // update product
        productService.update(product);

        return "redirect:/product/list";
    }


    @RequestMapping("{id}/delete")
    public String deleteProduct(@PathVariable("id") int id,
                                ModelMap model) {

        Product product = productService.findById(id);

        productService.delete(product);

        return "redirect:/product/list";
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listProducts(ModelMap model) {

        // retrieve a list of all products from product service
        List productList = productService.listAll();
        model.addAttribute("productList", productList);

        // open page
        model.addAttribute("content", "productList.jsp");
        // add current user
        User currentUser = userService.getCurrentUser();
        System.out.println("pageController - " + currentUser.getUsername());
        model.addAttribute("currentUser", currentUser);
        return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchProducts(@RequestParam(value = "searchString", required = false) String searchString,
                                 ModelMap model) {

//        productService.findByName( search_string );
        System.out.println("Search String: " + searchString);

        List<Product> resultList = new ArrayList<>();

        resultList.addAll(productService.findProducts("productName",
                searchString));
        resultList.addAll(productService.findProducts("description",
                searchString));
        resultList.addAll(productService.findProducts("productId",
                searchString));

        resultList = resultList.stream()
                .distinct()
                .collect(Collectors.toList());

        model.addAttribute("productList", resultList);

        // open page
        model.addAttribute("content", "productList.jsp");
        // add current user
        User currentUser = userService.getCurrentUser();
        System.out.println("pageController - " + currentUser.getUsername());
        model.addAttribute("currentUser", currentUser);

        return "index";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getCart(ModelMap model){

        User currentUser = userService.getCurrentUser();

        if( currentUser instanceof Buyer){

            Cart cart = ((Buyer) currentUser).getCart();

            if( cart != null ){

                List<Product> productList = cart.getProductList();
                model.addAttribute("productList", productList);
            } else {
                model.addAttribute("productList", new ArrayList<>());
            }


            model.addAttribute("content", "cart.jsp");

            return "index";
        }


        return "redirect:/product/list";
    }

    @RequestMapping(value = "{id}/addToCart")
    public String addToCart(@PathVariable("id") int id, ModelMap model){

        Product product = productService.findById(id);

        User currentUser = userService.getCurrentUser();
        System.out.println("addToCart - " + currentUser.getUsername());
        if( currentUser instanceof  Buyer) {
            userService.addToCart(currentUser, product);
        }

        return "redirect:/product/list";
    }

    @RequestMapping("{id}/cart/delete")
    public String removeFromCart(@PathVariable("id") int id,
                                ModelMap model) {

        Product product = productService.findById(id);

        User currentUser = userService.getCurrentUser();

        userService.removeFromCart(currentUser, product);

        return "redirect:/product/cart";
    }

    @RequestMapping(value = "/pay")
    public String pay( ModelMap model ){

        userService.createOrder();

        return "redirect:/product/list";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String getOrders(ModelMap model){

        Set<Order> orderList = new HashSet<>();
        User currentUser = userService.getCurrentUser();
        if(currentUser instanceof Buyer){
            orderList = ((Buyer) currentUser).getOrders();
        } else {
            orderList.addAll( userService.listAllOrders() );
        }

        model.addAttribute("currentUser", currentUser);
        model.addAttribute("orderList", orderList);
        // show page
        model.addAttribute("content", "orderList.jsp");

        return "index";
    }

    @RequestMapping(value = "{id}/order/cancel")
    public String cancelOrder(@PathVariable("id") int id ,ModelMap model){

        Order order = userService.findOrderById(id);

        boolean canceled = userService.cancelOrder((Buyer) userService.getCurrentUser(),
                order);
        System.out.println("Cancel order - " + String.valueOf(canceled));

        return "redirect:/product/orders";
    }

    @RequestMapping(value = "{id}/order/approve")
    public String approveCancelOrder(@PathVariable("id") int id ,ModelMap model){

        Order order = userService.findOrderById(id);

        boolean canceled = userService.approveCancelOrder(order);
        System.out.println("Cancel order - " + String.valueOf(canceled) );

        return "redirect:/product/orders";
    }
}
