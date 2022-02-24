package com.example.demo.dto

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "borrower", schema = "microloans")
class BorrowerInput(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,
  val userId: Long,
  val personalDataId: Long,
  val workId: Long,
  val addressId: Long
) {
  constructor() : this(0,0,0,0,0)

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as BorrowerInput

    if (id != other.id) return false
    if (userId != other.userId) return false
    if (personalDataId != other.personalDataId) return false
    if (workId != other.workId) return false
    if (addressId != other.addressId) return false

    return true
  }

  override fun hashCode(): Int {
    var result = id.hashCode()
    result = 31 * result + userId.hashCode()
    result = 31 * result + personalDataId.hashCode()
    result = 31 * result + workId.hashCode()
    result = 31 * result + addressId.hashCode()
    return result
  }

  override fun toString(): String {
    return "BorrowerInput(id=$id, userId=$userId, personalDataId=$personalDataId, workId=$workId, addressId=$addressId)"
  }


}
