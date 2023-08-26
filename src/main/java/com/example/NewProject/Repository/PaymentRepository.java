package com.example.NewProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NewProject.Model.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
