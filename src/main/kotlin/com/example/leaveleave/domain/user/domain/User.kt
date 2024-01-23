package com.example.leaveleave.domain.user.domain

import com.example.leaveleave.global.entity.BaseUUIDEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "tbl_user")
class User(
    @Id

    @Column(length = 15, nullable = false)
    var accountId: String,

    @Column(length = 200, nullable = false)
    var password: String,

    @Column(length = 5, nullable = false)
    var name: String,

    @Column(length = 20, nullable = false)
    var phoneNumber: String,

) : BaseUUIDEntity() {
    fun updateUserInfo(name: String) {
        this.name = name
    }

    fun updatePassword(password: String) {
        this.password = password
    }
}