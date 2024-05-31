package com.example.shopperspringmvc.rep;

import com.example.shopperspringmvc.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRep extends JpaRepository<Product, Long> {
}
