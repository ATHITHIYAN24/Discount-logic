package com.discountlogic.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserData {

    private String name;
    private String email;
    private String userType;
    private String purchaseStartDate;
}
