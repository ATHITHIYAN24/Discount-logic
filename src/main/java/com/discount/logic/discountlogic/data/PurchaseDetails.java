package com.discount.logic.discountlogic.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class PurchaseDetails {

    private String email;
    private BigDecimal billAmount;
}
