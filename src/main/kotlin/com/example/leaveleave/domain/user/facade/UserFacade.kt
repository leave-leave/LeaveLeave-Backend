package com.example.leaveleave.domain.user.facade

import com.example.leaveleave.domain.user.domain.repository.UserRepository
import com.example.leaveleave.domain.user.exception.UserNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import com.example.leaveleave.domain.user.domain.User

@Component
class UserFacade(
    private val userRepository: UserRepository
) {
    fun getCurrentUser(): User {
        val accountId: String = SecurityContextHolder.getContext().authentication.name
        return getByAccountId(accountId)
    }

    fun checkAccountIdExist(accountId: String): Boolean {
        return userRepository.existsByAccountId(accountId)
    }

    fun getByAccountId(accountId: String): User {
        return userRepository.findByAccountId(accountId) ?: throw UserNotFoundException
    }
}