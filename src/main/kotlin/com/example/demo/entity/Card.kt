package com.example.demo.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "card", schema = "microloans")
class Card(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,
  var number: String,
  var fullName: String,
  var cvc: Int,
  var userId: Long
) {
  constructor() : this(1, "", "", 1, 1)

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as Card

    if (id != other.id) return false
    if (number != other.number) return false
    if (fullName != other.fullName) return false
    if (cvc != other.cvc) return false
    if (userId != other.userId) return false

    return true
  }

  override fun hashCode(): Int {
    var result = id.hashCode()
    result = 31 * result + number.hashCode()
    result = 31 * result + fullName.hashCode()
    result = 31 * result + cvc
    result = 31 * result + userId.hashCode()
    return result
  }

  override fun toString(): String {
    return "Card(id=$id, number='$number', fullName='$fullName', cvc=$cvc, userId=$userId)"
  }
}
