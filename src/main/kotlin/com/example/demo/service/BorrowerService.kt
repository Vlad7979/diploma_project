package com.example.demo.service

import com.example.demo.dto.BorrowerInput
import com.example.demo.entity.Borrower

interface BorrowerService {

  fun getAll(): List<Borrower>

  fun get(id: Long): Borrower

  fun create(borrowerInput: BorrowerInput): BorrowerInput

  fun delete(id: Long)
}
