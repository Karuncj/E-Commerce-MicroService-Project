package com.order.Order_service.Controller;

import com.order.Order_service.Entity.Order;
import com.order.Order_service.Repo.OrderRepository;
import com.order.Order_service.Client.InventoryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    @PostMapping
    public String placeOrder(@RequestBody Order order) {

        // 1. Ask the Inventory Service if the product is available
        boolean inStock = inventoryClient.isInStock(order.getSkuCode());

        // 2. Decide whether to place the order
        if (inStock) {
            order.setOrderNumber(UUID.randomUUID().toString());
            orderRepository.save(order);
            return "Order Placed Successfully!";
        } else {
            return "Order Failed: Product " + order.getSkuCode() + " is currently out of stock.";
        }
    }
}