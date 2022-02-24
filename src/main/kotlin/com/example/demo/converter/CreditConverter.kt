package com.example.demo.converter

import com.example.demo.dto.CreditInput
import com.example.demo.entity.Credit
import org.springframework.stereotype.Component

@Component
class CreditConverter: DefaultConverter<CreditInput, Credit> {

  override fun fromDtoToEntity(dto: CreditInput): Credit {
    val result = Credit()
//    result.status = dto.status
//    result.percentPerDay = dto.percentPerDay
//    result.mainDebt = dto.mainDebt
//    result.dateRequested = dto.dateRequested
//    result.borrowerId = dto.borrowerId
//    result.dateRepaid = dto.dateRepaid
//    result.amount = dto.amount
    return result
  }

  override fun fromEntityToDto(entity: Credit): CreditInput {
    TODO("Not yet implemented")
  }
}
