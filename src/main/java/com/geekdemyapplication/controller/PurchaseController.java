package com.geekdemyapplication.controller;


import com.geekdemyapplication.entity.Purchase;
import com.geekdemyapplication.repo.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @PostMapping("/savepurchase")
    public Purchase createPurchase(@RequestBody Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    @GetMapping("/getallpurchase")
    public List<Purchase> getPurchases() {
        return purchaseRepository.findAll();
    }
}
