package com.example.shopperspringmvc.rep;

import com.example.shopperspringmvc.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRep extends JpaRepository<Customer, Long> {

}
