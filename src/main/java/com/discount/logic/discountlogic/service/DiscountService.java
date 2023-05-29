package com.discount.logic.discountlogic.service;

import com.discount.logic.discountlogic.data.PurchaseDetails;

import java.math.BigDecimal;

public interface DiscountService {

    public BigDecimal calculateFinalAmount(PurchaseDetails purchaseDetails);
}
