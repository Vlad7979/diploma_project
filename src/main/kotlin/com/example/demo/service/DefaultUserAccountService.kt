package com.example.demo.service

import com.example.demo.entity.UserAccount
import com.example.demo.repository.UserAccountRepository
import org.springframework.stereotype.Service

@Service
class DefaultUserAccountService(
  private val repository: UserAccountRepository
): UserAccountService {

  override fun getAll(): List<UserAccount> {
    return repository.findAll()
  }

  override fun get(id: Long): UserAccount {
    return repository.findById(id).get()
  }

  override fun create(userAccount: UserAccount): UserAccount {
    return repository.save(userAccount)
  }

  override fun delete(id: Long) {
    return repository.deleteById(id)
  }

  override fun block(id: Long) {
    val userAccount = repository.findById(id)
    userAccount.get().blocked = true
    repository.save(userAccount.get())
  }
}
