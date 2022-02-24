package com.example.demo.entity

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "payment", schema = "microloans")
class Payment(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,
  var creditId: Long,
  var amount: Int,
  var receivedDate: LocalDate
) {
  constructor() : this(0, 0,0, LocalDate.now())

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as Payment

    if (id != other.id) return false
    if (creditId != other.creditId) return false
    if (amount != other.amount) return false
    if (receivedDate != other.receivedDate) return false

    return true
  }

  override fun hashCode(): Int {
    var result = id.hashCode()
    result = 31 * result + creditId.hashCode()
    result = 31 * result + amount
    result = 31 * result + receivedDate.hashCode()
    return result
  }

  override fun toString(): String {
    return "Payment(id=$id, creditId=$creditId, amount=$amount, receivedDate=$receivedDate)"
  }
}
