package com.example.demo.service

import com.example.demo.dto.PaymentInput
import com.example.demo.entity.Payment
import com.example.demo.repository.PaymentRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class DefaultPaymentService(
  private val repository: PaymentRepository,
  private val creditService: CreditService
): PaymentService {

  override fun getByCredit(id: Long): List<Payment> {
    return repository.findAllByCreditId(id)
  }

  override fun getById(id: Long): Payment {
    return repository.getById(id)
  }

  override fun create(paymentRequest: PaymentInput): Payment {
    val payment = Payment()
    payment.amount = paymentRequest.amount
    payment.creditId = paymentRequest.creditId
    payment.receivedDate = LocalDate.now()
    creditService.updateAmount(creditService.getById(paymentRequest.creditId).id, paymentRequest.amount)
    return repository.save(payment)
  }

  override fun delete(id: Long) {
    return repository.deleteById(id)
  }
}
