package com.inventory.Inventory_service.Repo;

import com.inventory.Inventory_service.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Product, Long> {
    Optional<Product> findBySkuCode(String skuCode);

}
