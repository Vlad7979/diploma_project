package com.example.demo.converter

import com.example.demo.dto.CardInput
import com.example.demo.entity.Card
import org.springframework.stereotype.Component

@Component
class CardConverter: DefaultConverter<CardInput, Card> {

  override fun fromDtoToEntity(dto: CardInput): Card {
    val result = Card()
    result.number = dto.number
    result.fullName = dto.fullName
    result.cvc = dto.cvc
    result.userId = dto.userId
    return result
  }

  override fun fromEntityToDto(entity: Card): CardInput {
    return CardInput("", "", 1, 1)
  }
}
