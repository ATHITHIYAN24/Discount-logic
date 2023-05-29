package com.discountlogic.controller;

import com.discountlogic.data.PurchaseDetails;
import com.discountlogic.exception.UserNotFoundException;
import com.discountlogic.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @GetMapping("/getFinalBillAmount")
    public BigDecimal calculateFinalBillAmount(@Valid @RequestBody PurchaseDetails purchaseDetails) throws UserNotFoundException {
        return discountService.calculateFinalAmount(purchaseDetails);
    }
}
