package com.discount.logic.discountlogic.repository;

import com.discount.logic.discountlogic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
