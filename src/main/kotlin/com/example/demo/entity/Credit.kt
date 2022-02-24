package com.example.demo.entity

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "credit", schema = "microloans")
class Credit(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,
  var userId: Long,
  var dateRequested: LocalDate,
  var dateRepaid: LocalDate,
  var amount: Int,
  var status: String,
  var percent: Int,
  var mainDebt: Int
) {
  constructor() : this(0, 0, LocalDate.now(), LocalDate.now(), 0, "", 0, 0)

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as Credit

    if (id != other.id) return false
    if (userId != other.userId) return false
    if (dateRequested != other.dateRequested) return false
    if (dateRepaid != other.dateRepaid) return false
    if (amount != other.amount) return false
    if (status != other.status) return false
    if (percent != other.percent) return false
    if (mainDebt != other.mainDebt) return false

    return true
  }

  override fun hashCode(): Int {
    var result = id.hashCode()
    result = 31 * result + userId.hashCode()
    result = 31 * result + dateRequested.hashCode()
    result = 31 * result + dateRepaid.hashCode()
    result = 31 * result + amount.hashCode()
    result = 31 * result + status.hashCode()
    result = 31 * result + percent
    result = 31 * result + mainDebt
    return result
  }

  override fun toString(): String {
    return "Credit(id=$id, userId=$userId, dateRequested=$dateRequested, dateRepaid=$dateRepaid, amount=$amount, status='$status', percentPerDay=$percent, mainDebt=$mainDebt)"
  }
}
