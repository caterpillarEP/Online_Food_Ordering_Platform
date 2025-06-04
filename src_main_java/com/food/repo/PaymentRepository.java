package com.food.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
