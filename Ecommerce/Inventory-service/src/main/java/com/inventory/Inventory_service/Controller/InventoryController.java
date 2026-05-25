package com.inventory.Inventory_service.Controller;

import com.inventory.Inventory_service.Entity.Product;
import com.inventory.Inventory_service.Repo.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api/inventory")
    @RequiredArgsConstructor
    public class InventoryController {

        private final InventoryRepository inventoryRepository;

        // This endpoint checks if a product is in stock
        @GetMapping("/{skuCode}")
        public boolean isInStock(@PathVariable String skuCode) {
            Product product = inventoryRepository.findBySkuCode(skuCode).orElse(null);
            return product != null && product.getStockQuantity() > 0;
        }

        // Helper endpoint to add mock data easily
        @PostMapping
        public String addProduct(@RequestBody Product product) {
            inventoryRepository.save(product);
            return "Product saved successfully";
        }
    }
