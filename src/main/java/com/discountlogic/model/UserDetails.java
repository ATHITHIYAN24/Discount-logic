package com.discountlogic.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotEmpty
    @NotBlank
    @NotNull
    private String name;

    @Column(name = "email",unique = true)
    @Email
    @NotEmpty
    @NotBlank
    @NotNull
    private String email;

    @Column(name = "user_type")
    @NotEmpty
    @NotBlank
    @NotNull
    private String userType;

    @Column(name = "purchase_start_date")
    private Date purchaseStartDate;


    public UserDetails(String name, String email, String userType, Date purchaseStartDate) {
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.purchaseStartDate = purchaseStartDate;
    }
}
