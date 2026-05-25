package com.order.Order_service.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

    @FeignClient(name="inventory-service" ,url="http://localhost:8082/api/inventory")
    public interface InventoryClient {

        @GetMapping("/{skuCode}")
        boolean isInStock(@PathVariable("skuCode") String skuCode);
    }
