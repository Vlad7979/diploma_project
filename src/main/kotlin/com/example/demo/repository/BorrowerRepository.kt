package com.example.demo.repository

import com.example.demo.dto.BorrowerInput
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BorrowerRepository: JpaRepository<BorrowerInput, Long>
