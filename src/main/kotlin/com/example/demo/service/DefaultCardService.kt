package com.example.demo.service

import com.example.demo.converter.CardConverter
import com.example.demo.dto.CardInput
import com.example.demo.entity.Card
import com.example.demo.repository.CardRepository
import org.springframework.stereotype.Service

@Service
class DefaultCardService(
  private val repository: CardRepository,
  private val converter: CardConverter
): CardService {

  override fun getAll(): List<Card> {
    return repository.findAll()
  }

  override fun get(id: Long): Card {
    return repository.getById(id)
  }

  override fun getUserCards(userid: Long): List<Card> {
    return repository.getCardsByUserId(userid)
  }

  override fun create(card: CardInput): Card {
    return repository.save(converter.fromDtoToEntity(card))
  }

  override fun update(card: Card): Card {
    val result = repository.getById(card.id)
    result.fullName = card.fullName
    result.number = card.number
    result.cvc = card.cvc
    return repository.save(result)
  }

  override fun delete(id: Long) {
    return repository.deleteById(id)
  }
}
