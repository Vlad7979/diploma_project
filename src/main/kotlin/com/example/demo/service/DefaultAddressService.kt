package com.example.demo.service

import com.example.demo.entity.Address
import com.example.demo.repository.AddressRepository
import org.springframework.stereotype.Service

@Service
class DefaultAddressService(
  private val repository: AddressRepository
): AddressService {

  override fun getAll(): List<Address> {
    return repository.findAll()
  }

  override fun get(id: Long): Address {
    return repository.getById(id)
  }

  override fun create(address: Address): Address {
    return repository.save(address)
  }

  override fun update(address: Address): Address {
    val result = repository.getById(address.id)
    result.city = address.city
    result.street = address.street
    result.houseNumber = address.houseNumber
    return repository.save(result)
  }

  override fun delete(id: Long) {
    return repository.deleteById(id)
  }
}
