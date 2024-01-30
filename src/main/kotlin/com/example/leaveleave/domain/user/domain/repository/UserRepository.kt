package com.example.leaveleave.domain.user.domain.repository

import com.example.leaveleave.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String> {
    fun findByAccountId(accountId: String): User?
    fun existsByAccountId(accountId: String): Boolean
}