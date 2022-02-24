package com.example.demo.repository

import com.example.demo.entity.Payment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentRepository: JpaRepository<Payment, Long> {

  fun findAllByCreditId(creditId: Long): List<Payment>
}
