package com.example.demo.repository

import com.example.demo.entity.Card
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CardRepository: JpaRepository<Card, Long> {
    fun getCardsByUserId(userId: Long): List<Card>
}
