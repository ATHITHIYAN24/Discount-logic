package com.discountlogic.service;

import com.discountlogic.data.UserData;
import com.discountlogic.model.UserDetails;

import java.text.ParseException;

public interface UserService {

     UserDetails saveUserDetails(UserData userData) throws ParseException;

}
