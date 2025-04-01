package com.example.ration_system_application.ration_system_application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ration_system_application.ration_system_application.entity.Stock;
import com.example.ration_system_application.ration_system_application.repository.StockRepository;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public Stock updateStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public Stock getStock(String itemName) {
        return stockRepository.findByItemName(itemName).orElseThrow(() -> new RuntimeException("Stock not found"));
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
}

