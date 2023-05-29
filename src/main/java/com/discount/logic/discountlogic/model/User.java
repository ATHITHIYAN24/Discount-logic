package com.discount.logic.discountlogic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "purchase_start_date")
    private LocalDate purchaseStartDate;


    public User(String name, String email, String userType, LocalDate purchaseStartDate) {
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.purchaseStartDate = purchaseStartDate;
    }
}
