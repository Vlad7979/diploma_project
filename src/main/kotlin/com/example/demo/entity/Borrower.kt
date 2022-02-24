package com.example.demo.entity

import com.example.demo.model.User

data class Borrower(
  val id: Long,
  val user: User,
  val personalData: PersonalData,
  val work: Work,
  val address: Address
)
