package com.example.demo.controller

import com.example.demo.dto.PaymentInput
import com.example.demo.entity.Payment
import com.example.demo.service.PaymentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/payment")
@CrossOrigin("*")
class PaymentController(
  private val service: PaymentService
) {

  @GetMapping("/get-by-credit")
  fun getByCredit(@RequestParam("id") id: Long) = service.getByCredit(id)

  @GetMapping("/get/{id}")
  fun getById(@PathVariable id: Long) = service.getById(id)

  @PostMapping("/create")
  fun create(@RequestBody payment: PaymentInput) = service.create(payment)

  @DeleteMapping("/delete/{id}")
  fun delete(@PathVariable id: Long) = service.delete(id)
}
