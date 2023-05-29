package com.discount.logic.discountlogic.service;

import com.discount.logic.discountlogic.model.User;
import com.discount.logic.discountlogic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUserDetails(User user) {
        return userRepository.save(user);
    }
}
