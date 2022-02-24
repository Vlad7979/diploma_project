package com.example.demo.service

import com.example.demo.dto.CreditInput
import com.example.demo.entity.Credit
import com.example.demo.repository.CreditRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class DefaultCreditService(
  private val repository: CreditRepository
): CreditService {

  override fun getAll(): List<Credit> {
    return repository.findAll()
  }

  override fun getByUserId(id: Long): List<Credit> {
    return repository.findAllByUserId(id)
  }

  override fun getById(id: Long): Credit {
    return repository.getById(id)
  }

  override fun create(creditInput: CreditInput): Credit {
    val credit = Credit()
    credit.status = "ACTIVE"
    credit.dateRequested = LocalDate.now()
    when (creditInput.percent) {
      2 -> credit.dateRepaid = LocalDate.now().plusWeeks(1)
      5 -> credit.dateRepaid = LocalDate.now().plusMonths(1)
      10 -> credit.dateRepaid = LocalDate.now().plusMonths(6)
    }
    credit.amount = creditInput.amount
    credit.mainDebt = creditInput.amount
    credit.userId = creditInput.userId
    credit.percent = creditInput.percent
    return repository.save(credit)
  }

  override fun updateAmount(id: Long, amount: Int): Credit {
    val credit = repository.getById(id)
    credit.mainDebt = credit.mainDebt - amount
    return repository.save(credit)
  }

  override fun getMainDebt(creditId: Long): Int {
    return repository.getById(creditId).mainDebt
  }

  override fun update(credit: Credit): Credit {
    val result = getById(credit.id)
    result.amount = credit.amount
    result.userId = credit.userId
    result.dateRepaid = credit.dateRepaid
    result.dateRequested = credit.dateRequested
    result.mainDebt = credit.mainDebt
    result.percent = credit.percent
    result.status = credit.status
    return repository.save(result)
  }

  override fun delete(id: Long) {
    return repository.deleteById(id)
  }
}
