package com.geekdemyapplication.controller;


import com.geekdemyapplication.entity.Purchase;
import com.geekdemyapplication.repo.PurchaseRepository;
import com.geekdemyapplication.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private BillingService billingService;

    @GetMapping("/getbill")
    public Double calculateTotalBill() {
        List<Purchase> purchases = purchaseRepository.findAll();
        return billingService.calculateTotalBill(purchases);
    }
}