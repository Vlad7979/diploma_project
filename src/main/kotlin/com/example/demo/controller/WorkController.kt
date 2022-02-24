package com.example.demo.controller

import com.example.demo.dto.WorkInput
import com.example.demo.entity.Work
import com.example.demo.service.WorkService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/work")
@CrossOrigin("*")
class WorkController(
  private val service: WorkService
) {

  @GetMapping("/get")
  fun getAll() = service.getAll()

  @GetMapping("/get/{id}")
  fun get(@PathVariable id: Long) = service.get(id)

  @PostMapping("/create")
  fun create(@RequestBody work: WorkInput) = service.create(work)
}
