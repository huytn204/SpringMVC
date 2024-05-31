package com.example.shopperspringmvc.rep;

import com.example.shopperspringmvc.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRep extends JpaRepository<Order, Long> {
}
