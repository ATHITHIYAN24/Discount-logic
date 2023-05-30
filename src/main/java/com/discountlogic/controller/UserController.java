package com.discountlogic.controller;


import com.discountlogic.data.UserData;
import com.discountlogic.model.UserDetails;
import com.discountlogic.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;

@RestController
@Api(value="UserDetails")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    @ApiOperation(value="Add User", response=UserDetails.class)
    public UserDetails saveUserDetails(@RequestBody UserData userData) throws ParseException {
        return userService.saveUserDetails(userData);
    }


}
