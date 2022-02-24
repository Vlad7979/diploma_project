package com.example.demo.service

import com.example.demo.dto.PaymentInput
import com.example.demo.entity.Payment

interface PaymentService {

  fun getByCredit(id: Long): List<Payment>

  fun getById(id: Long): Payment

  fun create(paymentRequest: PaymentInput): Payment

  fun delete(id: Long)
}
