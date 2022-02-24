package com.example.demo.controller

import com.example.demo.entity.Address
import com.example.demo.service.AddressService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/address")
@CrossOrigin("*")
class AddressController(
  private val service: AddressService
) {

  @GetMapping("/get")
  fun getAll() = service.getAll()

  @GetMapping("/get/{id}")
  fun get(@PathVariable id: Long) = service.get(id)

  @PostMapping("/create")
  fun create(@RequestBody address: Address) = service.create(address)

  @PutMapping("/update")
  fun update(@RequestBody address: Address) = service.update(address)

  @DeleteMapping("/delete/{id}")
  fun delete(@PathVariable id: Long) = service.delete(id)
}
