package com.litaos.controller;

import com.litaos.model.User;
import com.litaos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by litaoshen on 10/09/2015.
 */

@Controller
@RequestMapping("/")
public class HomePageController {

    @Qualifier("userServiceImp")
    @Autowired
    UserService userService;

//    private static boolean isSeed = false;

    @RequestMapping(method = RequestMethod.GET)
    public String openHome(ModelMap model ){

//        if( ! isSeed ){
//            ObjectRepository objectRepository = new ObjectMapper();
//            TestDB.seedData(objectRepository);
//            isSeed = true;
//        }

        User user = userService.getCurrentUser();
        boolean logined = false;
        String userType = "";
        if( user != null ) {
            logined = true;
            userType = user.getType();
        }

        model.addAttribute("logined", logined);

        model.addAttribute("userType", userType);

        String content = "shoppingHome.jsp";

        model.addAttribute("content", content);

        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("userForm") User user, ModelMap model){


        boolean success = userService.login(user.getUsername(), user.getPassword());
        System.out.println("Login status: " + String.valueOf(success));

//        User buyer = userService.getCurrentUser();
//        System.out.println(buyer.getUsername());

        return "redirect:/";
    }
    @RequestMapping(value = "/logout")
    public String logout( ModelMap model){

        userService.logout();

        return "redirect:/";
    }

}
