package com.example.leaveleave.domain.user.domain.repository

import com.example.leaveleave.domain.user.domain.User
import jakarta.persistence.Id
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository : JpaRepository<User, UUID> {
    fun findByAccountId(accountId: String): User?
    fun existsByAccountId(accountId: String): Boolean
}