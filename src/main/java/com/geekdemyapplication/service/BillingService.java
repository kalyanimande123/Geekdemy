package com.geekdemyapplication.service;


import com.geekdemyapplication.entity.Purchase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {
    public Double calculateTotalBill(List<Purchase> purchases) {
        Double totalBill = 0.0;
        Integer totalProgrammes = purchases.stream().mapToInt(Purchase::getQuantity).sum();
        for (Purchase purchase : purchases) {
            Double price = purchase.getProgramme().getPrice();
            Integer quantity = purchase.getQuantity();
            Double discountedPrice = price;
            if (totalProgrammes >= 10) {
                discountedPrice = price * 0.8;
            } else if (totalProgrammes >= 5) {
                discountedPrice = price * 0.9;
            }
            totalBill += discountedPrice * quantity;
        }
        return totalBill;
    }
}
