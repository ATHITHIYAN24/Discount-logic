package com.discountlogic.service;

import com.discountlogic.data.UserData;
import com.discountlogic.model.UserDetails;
import com.discountlogic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails saveUserDetails(UserData userData) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        UserDetails userDetails = new UserDetails(userData.getName(), userData.getEmail(), userData.getUserType(), formatter.parse(userData.getPurchaseStartDate()));
        return userRepository.save(userDetails);
    }
}
