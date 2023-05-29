package com.discountlogic.service;

import com.discountlogic.data.PurchaseDetails;
import com.discountlogic.repository.UserRepository;
import com.discountlogic.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    UserRepository userRepository;
    @Override
    public BigDecimal calculateFinalAmount(PurchaseDetails purchaseDetails) {

        BigDecimal billAmount= purchaseDetails.getBillAmount();
        User user = userRepository.findByEmail(purchaseDetails.getEmail());
        BigDecimal discountAmountPerHundredDollar= new BigDecimal("5");


        if(purchaseDetails.getProductsType() != "GROCERY") {
            if(user.getUserType().equals("employee")) {
                billAmount = nonGroceryProductDiscount(billAmount,BigDecimal.valueOf(30l));
            } else if (user.getUserType().equals("affiliate")) {
                billAmount = nonGroceryProductDiscount(billAmount,BigDecimal.valueOf(10l));
            } else if (user.getUserType().equals("customer") ) {
                long noOfYears = user.getPurchaseStartDate().until(LocalDate.now(), ChronoUnit.YEARS);
                if(noOfYears > 2) {
                    billAmount = nonGroceryProductDiscount(billAmount,BigDecimal.valueOf(5l));
                }
            }
        }
        BigDecimal commonDiscountAmount = purchaseDetails.getBillAmount().divide(BigDecimal.valueOf(100l))
                .multiply(discountAmountPerHundredDollar);

        return billAmount.subtract(commonDiscountAmount) ;
    }

    private BigDecimal nonGroceryProductDiscount(BigDecimal billAmount,BigDecimal percentage) {
        BigDecimal discountAmount = billAmount.divide(percentage);
        return billAmount.subtract(discountAmount);
    }

}
