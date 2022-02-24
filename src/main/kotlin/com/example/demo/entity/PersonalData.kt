package com.example.demo.entity

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "personal_data", schema = "microloans")
class PersonalData(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long,
  var birthday: LocalDate,
  var firstName: String,
  var lastName: String
) {
  constructor() : this(1,  LocalDate.now(), "", "")

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as PersonalData

    if (id != other.id) return false
    if (birthday != other.birthday) return false
    if (firstName != other.firstName) return false
    if (lastName != other.lastName) return false

    return true
  }

  override fun hashCode(): Int {
    var result = id.hashCode()
    result = 31 * result + birthday.hashCode()
    result = 31 * result + firstName.hashCode()
    result = 31 * result + lastName.hashCode()
    return result
  }

  override fun toString(): String {
    return "PersonalData(id=$id, birthday=$birthday, firstName='$firstName', lastName='$lastName'"
  }
}
