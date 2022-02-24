package com.example.demo.service

import com.example.demo.dto.CreditInput
import com.example.demo.entity.Credit

interface CreditService {

  fun getAll(): List<Credit>

  fun getByUserId(id: Long): List<Credit>

  fun getById(id: Long): Credit

  fun getMainDebt(creditId: Long): Int

  fun create(creditInput: CreditInput): Credit

  fun update(credit: Credit): Credit

  fun updateAmount(id: Long, amount: Int): Credit

  fun delete(id: Long)
}
