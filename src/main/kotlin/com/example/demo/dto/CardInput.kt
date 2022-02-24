package com.example.demo.dto

data class CardInput(
  val number: String,
  val fullName: String,
  val cvc: Int,
  val userId: Long
)
