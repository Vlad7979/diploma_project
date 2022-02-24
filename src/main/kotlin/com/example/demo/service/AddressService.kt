package com.example.demo.service

import com.example.demo.entity.Address

interface AddressService {

  fun getAll(): List<Address>

  fun get(id: Long): Address

  fun create(address: Address): Address

  fun update(address: Address): Address

  fun delete(id: Long)
}
