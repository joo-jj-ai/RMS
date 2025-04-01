package com.example.ration_system_application.ration_system_application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ration_system_application.ration_system_application.entity.Stock;
import com.example.ration_system_application.ration_system_application.service.StockService;

@CrossOrigin
@RestController
@RequestMapping("/stocks")

public class StockController {
    @Autowired
    private StockService stockService;

    @PostMapping("/add")
    public Stock addStock(@RequestBody Stock stock) {
        return stockService.addStock(stock);
    }

    @GetMapping("/{itemName}")
    public Stock getStock(@PathVariable String itemName) {
        return stockService.getStock(itemName);
    }

    @GetMapping("/all")
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }
}

