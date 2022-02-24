package com.example.demo.controller

import com.example.demo.dto.PersonalDataInput
import com.example.demo.entity.PersonalData
import com.example.demo.service.PersonalDataService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/personal-data")
@CrossOrigin("*")
class PersonalDataController(
  private val service: PersonalDataService
) {

  @GetMapping("/get")
  fun getAll() = service.getAll()

  @GetMapping("/get/{id}")
  fun get(@PathVariable id: Long) = service.get(id)

  @PostMapping("/create")
  fun create(@RequestBody personalData: PersonalDataInput) = service.create(personalData)

  @PutMapping("/update")
  fun update(@RequestBody personalData: PersonalData) = service.update(personalData)

  @DeleteMapping("/delete/{id}")
  fun delete(@PathVariable id: Long) = service.delete(id)
}
