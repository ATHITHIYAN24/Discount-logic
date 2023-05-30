package com.discountlogic.controller;

import com.discountlogic.data.PurchaseDetails;
import com.discountlogic.exception.UserNotFoundException;
import com.discountlogic.service.DiscountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@Api(value="Discount")
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @GetMapping("/discountedBillAmount")
    @ApiOperation(value="Apply Discount to the bill amount", response= BigDecimal.class)
    public BigDecimal calculateFinalBillAmount(@Valid @RequestBody PurchaseDetails purchaseDetails) throws UserNotFoundException {
        return discountService.calculateFinalAmount(purchaseDetails);
    }
}
