package com.example.demo.entity

import org.hibernate.Hibernate
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user_account", schema = "microloans")
class UserAccount(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,
  val dateCreated: Date = Date(),
  val email: String,
  val password: String,
  var blocked: Boolean = false
) {
  constructor(): this(0, Date(), "", "", false)

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
    other as UserAccount

    return id == other.id
  }

  override fun hashCode(): Int = javaClass.hashCode()

  @Override
  override fun toString(): String {
    return this::class.simpleName + "(id = $id , dateCreated = $dateCreated , email = $email , password = $password , blocked = $blocked )"
  }
}
