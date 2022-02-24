package com.example.demo.repository

import com.example.demo.entity.PersonalData
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonalDataRepository: JpaRepository<PersonalData, Long>
