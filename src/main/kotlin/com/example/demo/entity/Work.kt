package com.example.demo.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "work", schema = "microloans")
class Work(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,
  var salary: Int,
  var education: String,
  var industry: String
) {
  constructor() : this(1, 1, "", "")

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as Work

    if (id != other.id) return false
    if (salary != other.salary) return false
    if (education != other.education) return false
    if (industry != other.industry) return false

    return true
  }

  override fun hashCode(): Int {
    var result = id.hashCode()
    result = 31 * result + salary
    result = 31 * result + education.hashCode()
    result = 31 * result + industry.hashCode()
    return result
  }

  override fun toString(): String {
    return "Work(id=$id, salary=$salary, education='$education', industry='$industry')"
  }
}
