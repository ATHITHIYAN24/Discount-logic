package com.discountlogic.service;

import com.discountlogic.data.PurchaseDetails;
import com.discountlogic.exception.UserNotFoundException;
import com.discountlogic.repository.UserRepository;
import com.discountlogic.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    UserRepository userRepository;
    @Override
    public BigDecimal calculateFinalAmount(PurchaseDetails purchaseDetails) throws UserNotFoundException {

        BigDecimal billAmount= purchaseDetails.getBillAmount();
        UserDetails userDetails = userRepository.findByEmail(purchaseDetails.getEmail());
        if(userDetails==null) {
            throw new UserNotFoundException("User Not Found");
        }
        BigDecimal discountAmountPerHundredDollar= new BigDecimal("5");


        if(purchaseDetails.getProductsType() != "GROCERY") {
            if(userDetails.getUserType().equals("employee")) {
                billAmount = nonGroceryProductDiscount(billAmount,BigDecimal.valueOf(30l));
            } else if (userDetails.getUserType().equals("affiliate")) {
                billAmount = nonGroceryProductDiscount(billAmount,BigDecimal.valueOf(10l));
            } else if (userDetails.getUserType().equals("customer") ) {
                long noOfYears = userDetails.getPurchaseStartDate().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate().until(LocalDate.now(), ChronoUnit.YEARS);
                if(noOfYears > 2) {
                    billAmount = nonGroceryProductDiscount(billAmount,BigDecimal.valueOf(5l));
                }
            }
        }
        BigDecimal commonDiscountAmount = billAmount.divide(BigDecimal.valueOf(100l), RoundingMode.FLOOR)
                .multiply(discountAmountPerHundredDollar);

        return billAmount.subtract(commonDiscountAmount) ;
    }

    private BigDecimal nonGroceryProductDiscount(BigDecimal billAmount,BigDecimal percentage) {
        BigDecimal discountAmount = billAmount.multiply(percentage).divide(BigDecimal.valueOf(100l));
        return billAmount.subtract(discountAmount);
    }

}
