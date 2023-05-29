package com.discount.logic.discountlogic.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
@AllArgsConstructor
public class UserData {

    private String name;
    private String email;
    private String userType;
    private String purchaseStartDate;
}
