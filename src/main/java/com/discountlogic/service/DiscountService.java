package com.discountlogic.service;

import com.discountlogic.data.PurchaseDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

public interface DiscountService {

    public BigDecimal calculateFinalAmount(PurchaseDetails purchaseDetails);
}
