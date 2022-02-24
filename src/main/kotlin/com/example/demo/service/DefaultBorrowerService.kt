package com.example.demo.service

import com.example.demo.dto.BorrowerInput
import com.example.demo.entity.Borrower
import com.example.demo.repository.BorrowerRepository
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Service

@Service
class DefaultBorrowerService(
  private val repository: BorrowerRepository,
  private val personalDataService: PersonalDataService,
  private val userService: DefaultUserDetailsService,
  private val workService: WorkService,
  private val addressService: AddressService
) : BorrowerService {

  override fun getAll(): List<Borrower> {
    val borrowers = repository.findAll()
    val result = mutableListOf<Borrower>()
    borrowers.stream()
      .forEach {
        LOGGER.info("USER INFO: {}, {}, {}, {}, {}", it.id, it.userId, it.personalDataId, it.workId, it.addressId)
        result.add(
          Borrower(
            it.id,
            userService.get(it.userId),
            personalDataService.get(it.personalDataId),
            workService.get(it.workId),
            addressService.get(it.addressId)
          )
        )
      }
    return result
  }

  override fun get(id: Long): Borrower {
    val borrower = repository.getById(id)
    val result = Borrower(
      id,
      userService.get(borrower.userId),
      personalDataService.get(borrower.personalDataId),
      workService.get(borrower.workId),
      addressService.get(borrower.addressId)
    )
    return result
  }

  override fun create(borrowerInput: BorrowerInput): BorrowerInput {
    return repository.save(borrowerInput)
  }

  override fun delete(id: Long) {
    repository.deleteById(id)
  }

  companion object {
    val LOGGER = LogManager.getLogger()
  }
}
