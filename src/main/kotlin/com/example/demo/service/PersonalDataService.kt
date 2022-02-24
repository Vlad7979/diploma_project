package com.example.demo.service

import com.example.demo.dto.PersonalDataInput
import com.example.demo.entity.PersonalData

interface PersonalDataService {

  fun getAll(): List<PersonalData>

  fun get(id: Long): PersonalData

  fun create(personalData: PersonalDataInput): PersonalData

  fun update(personalData: PersonalData): PersonalData

  fun delete(id: Long)
}
