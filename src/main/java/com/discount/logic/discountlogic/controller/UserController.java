package com.discount.logic.discountlogic.controller;

import com.discount.logic.discountlogic.data.UserData;
import com.discount.logic.discountlogic.model.User;
import com.discount.logic.discountlogic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save_user")
    public User saveUserDetails(@RequestBody UserData userData) {
        User user = new User(userData.getName(),userData.getEmail(),userData.getUserType(),LocalDate.parse(userData.getDate()));
        return userService.saveUserDetails(user);
    }


}
