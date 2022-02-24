package com.example.demo.service

import com.example.demo.converter.PersonalDataConverter
import com.example.demo.dto.PersonalDataInput
import com.example.demo.entity.PersonalData
import com.example.demo.repository.PersonalDataRepository
import org.springframework.stereotype.Service

@Service
class DefaultPersonalDataService(
  private val repository: PersonalDataRepository,
  private val converter: PersonalDataConverter
): PersonalDataService {

  override fun getAll(): List<PersonalData> {
    return repository.findAll()
  }

  override fun get(id: Long): PersonalData {
    return repository.getById(id)
  }

  override fun create(personalData: PersonalDataInput): PersonalData {
    return repository.save(converter.fromDtoToEntity(personalData))
  }

  override fun update(personalData: PersonalData): PersonalData {
    return repository.save(personalData)
  }

  override fun delete(id: Long) {
    return repository.deleteById(id)
  }
}
