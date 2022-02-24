package com.example.demo.converter

interface DefaultConverter<T, V> {

  fun fromDtoToEntity(dto: T): V

  fun fromEntityToDto(entity: V): T
}
