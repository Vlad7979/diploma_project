package com.example.demo.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "address", schema = "microloans")
class Address(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        var city: String,
        var street: String,
        var houseNumber: Int
) {
    constructor() : this(0, "", "", 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Address

        if (id != other.id) return false
        if (city != other.city) return false
        if (street != other.street) return false
        if (houseNumber != other.houseNumber) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + city.hashCode()
        result = 31 * result + street.hashCode()
        result = 31 * result + houseNumber
        return result
    }

    override fun toString(): String {
        return "Address(id=$id, city='$city', street='$street', houseNumber=$houseNumber)"
    }
}
