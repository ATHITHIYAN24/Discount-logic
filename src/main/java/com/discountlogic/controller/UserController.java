package com.discountlogic.controller;

import com.discount.logic.discountlogic.data.UserData;
import com.discountlogic.model.UserDetails;
import com.discountlogic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public UserDetails saveUserDetails(@RequestBody UserData userData) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        UserDetails userDetails = new UserDetails(userData.getName(),userData.getEmail(),userData.getUserType(),formatter.parse(userData.getPurchaseStartDate()));
        return userService.saveUserDetails(userDetails);

    }


}
