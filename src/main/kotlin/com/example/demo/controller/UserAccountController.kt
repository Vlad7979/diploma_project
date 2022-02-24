package com.example.demo.controller

import com.example.demo.entity.UserAccount
import com.example.demo.service.UserAccountService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user-account")
class UserAccountController(
  private val service: UserAccountService
) {

  @GetMapping("/get")
  fun getAll() = service.getAll()

  @GetMapping("/get/{id}")
  fun get(@PathVariable id: Long) = service.get(id)

  @PostMapping("/create")
  fun create(@RequestBody userAccount: UserAccount) = service.create(userAccount)

  @DeleteMapping("/delete/{id}")
  fun delete(@PathVariable id: Long) = service.delete(id)

  @PutMapping("/block/{id}")
  fun blockUserAccount(@PathVariable id: Long) = service.block(id)
}
