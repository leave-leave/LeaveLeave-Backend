package com.example.leaveleave.global.entity

import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id
import org.hibernate.annotations.GenericGenerator
import java.util.UUID

open class BaseUUIDEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid4", strategy = "ord.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    val id : UUID = UUID.randomUUID()

}