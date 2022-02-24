package com.example.demo.controller

import com.example.demo.dto.CardInput
import com.example.demo.entity.Card
import com.example.demo.service.CardService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/card")
@CrossOrigin("*")
class CardController(
  private val service: CardService
) {

  @GetMapping("/get")
  fun getAll() = service.getAll()

  @GetMapping("/get-by-user")
  fun getAllByUser(@RequestParam("id") id: Long) = service.getUserCards(id)

  @GetMapping("/get/{id}")
  fun get(@PathVariable id: Long) = service.get(id)

  @PostMapping("/create")
  fun create(@RequestBody card: CardInput) = service.create(card)

  @PutMapping("/update")
  fun update(@RequestBody card: Card) = service.update(card)

  @DeleteMapping("/delete/{id}")
  fun delete(@PathVariable id: Long) = service.delete(id)
}
