package com.discount.logic.discountlogic.controller;

import com.discount.logic.discountlogic.data.PurchaseDetails;
import com.discount.logic.discountlogic.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @GetMapping("/getFinalBillAmount")
    public BigDecimal calculateFinalBillAmount(@RequestBody PurchaseDetails purchaseDetails) {
        return discountService.calculateFinalAmount(purchaseDetails);
    }
}
