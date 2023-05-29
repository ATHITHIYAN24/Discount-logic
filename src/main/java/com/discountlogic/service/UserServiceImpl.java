package com.discountlogic.service;

import com.discountlogic.model.UserDetails;
import com.discountlogic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails saveUserDetails(UserDetails userDetails) {
        return userRepository.save(userDetails);
    }
}
