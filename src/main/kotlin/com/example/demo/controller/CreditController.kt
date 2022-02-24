package com.example.demo.controller

import com.example.demo.dto.CreditInput
import com.example.demo.entity.Credit
import com.example.demo.service.CreditService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/credit")
@CrossOrigin("*")
class CreditController(
  private val service: CreditService
) {

  @GetMapping("/get")
  fun getAll() = service.getAll()

  @GetMapping("/get-by-user")
  fun getByUser(@RequestParam("id") id: Long) = service.getByUserId(id)

  @GetMapping("/get-main-debt")
  fun getMainDebt(@RequestParam("id") id: Long) = service.getMainDebt(id)

  @PostMapping("/create")
  fun create(@RequestBody creditInput: CreditInput) = service.create(creditInput)

  @PutMapping("/update")
  fun update(@RequestBody credit: Credit) = service.update(credit)

  @DeleteMapping("/delete/{id}")
  fun delete(@PathVariable id: Long) = service.delete(id)
}
