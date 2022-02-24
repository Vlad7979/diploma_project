package com.example.demo.converter

import com.example.demo.dto.PersonalDataInput
import com.example.demo.entity.PersonalData
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Component
class PersonalDataConverter: DefaultConverter<PersonalDataInput, PersonalData> {

  override fun fromDtoToEntity(dto: PersonalDataInput): PersonalData {
    val result = PersonalData()
    result.birthday = LocalDate.parse(dto.birthday, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    result.firstName = dto.firstName
    result.lastName = dto.lastName
    return result
  }

  override fun fromEntityToDto(entity: PersonalData): PersonalDataInput {
    return PersonalDataInput("", "", "")
  }
}
