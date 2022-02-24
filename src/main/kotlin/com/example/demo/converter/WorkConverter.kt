package com.example.demo.converter

import com.example.demo.dto.WorkInput
import com.example.demo.entity.Work
import org.springframework.stereotype.Component

@Component
class WorkConverter: DefaultConverter<WorkInput, Work> {
    override fun fromDtoToEntity(dto: WorkInput): Work {
        val result = Work()
        result.salary = dto.salary
        result.education = dto.education
        result.industry = dto.industry
        return result
  }

    override fun fromEntityToDto(entity: Work): WorkInput {
        return WorkInput(0, "", "")
    }
}