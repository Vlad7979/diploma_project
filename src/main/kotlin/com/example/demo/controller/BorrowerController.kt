package com.example.demo.controller

import com.example.demo.dto.BorrowerInput
import com.example.demo.entity.Borrower
import com.example.demo.service.BorrowerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/borrower")
@CrossOrigin("*")
class BorrowerController(
  private val service: BorrowerService
) {

  @GetMapping("/get")
  fun getAll() = service.getAll()

  @GetMapping("/get/{id}")
  fun get(@PathVariable id: Long) = service.get(id)

  @PostMapping("/create")
  fun create(@RequestBody borrowerInput: BorrowerInput) = service.create(borrowerInput)

  @DeleteMapping("/delete/{id}")
  fun delete(@PathVariable id: Long) = service.delete(id)
}
