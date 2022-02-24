package com.example.demo.service

import com.example.demo.dto.WorkInput
import com.example.demo.entity.Work

interface WorkService {

  fun getAll(): List<Work>

  fun get(id: Long): Work

  fun create(work: WorkInput): Work
}
