package com.example.demo.service

import com.example.demo.dto.CardInput
import com.example.demo.entity.Card

interface CardService {

  fun getAll(): List<Card>

  fun get(id: Long): Card

  fun getUserCards(userid: Long): List<Card>

  fun create(card: CardInput): Card

  fun update(card: Card): Card

  fun delete(id: Long)
}
