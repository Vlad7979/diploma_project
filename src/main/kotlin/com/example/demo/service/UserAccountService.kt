package com.example.demo.service

import com.example.demo.entity.UserAccount

interface UserAccountService {

  fun getAll(): List<UserAccount>

  fun get(id: Long): UserAccount

  fun create(userAccount: UserAccount): UserAccount

  fun delete(id: Long)

  fun block(id: Long)
}
