package com.discountlogic.data;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class PurchaseDetails {

    @NotNull
    private String email;

    @NotNull
    private BigDecimal billAmount;

    @NotNull
    private String productsType;
}
