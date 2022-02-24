package com.example.demo.service

import com.example.demo.converter.WorkConverter
import com.example.demo.dto.WorkInput
import com.example.demo.entity.Work
import com.example.demo.repository.WorkRepository
import org.springframework.stereotype.Service

@Service
class DefaultWorkService(
  private val repository: WorkRepository,
  private val converter: WorkConverter
): WorkService {

  override fun getAll(): List<Work> {
    return repository.findAll()
  }

  override fun get(id: Long): Work {
    return repository.getById(id)
  }

  override fun create(work: WorkInput): Work {
    return repository.save(converter.fromDtoToEntity(work))
  }
}
