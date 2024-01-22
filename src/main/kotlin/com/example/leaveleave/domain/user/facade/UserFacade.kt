package com.example.leaveleave.domain.user.facade

import com.example.leaveleave.domain.user.domain.repository.UserRepository
import com.example.leaveleave.domain.user.exception.UserNotFoundException
import org.apache.catalina.User
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository
) {
    fun getCurrentUser(): com.example.leaveleave.domain.user.domain.User {
        val accountId : String = SecurityContextHolder.getContext().authentication.name
        return getByAccountId(accountId)
    }
    fun checkAccountIdExist(accountId: String) : Boolean{
        return userRepository.existsByAccountId(accountId)
    }
    fun getByAccountId(accountId: String): com.example.leaveleave.domain.user.domain.User {
        return userRepository.findByAccountId(accountId) ?: throw UserNotFoundException
    }
}