package com.example.leaveleave.domain.user.service

import com.example.leaveleave.domain.user.domain.User
import com.example.leaveleave.domain.user.domain.repository.UserRepository
import com.example.leaveleave.domain.user.exception.AlreadyAccountIdException
import com.example.leaveleave.domain.user.facade.UserFacade
import com.example.leaveleave.domain.user.presentation.dto.request.SignUpRequest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SignUpService(
    private val userRepository: UserRepository,
    private val userFacade: UserFacade,
    private val passwordEncoder: PasswordEncoder,
) {
    @Transactional
    fun execute(request: SignUpRequest) {
        userRepository.save(
            User(
                request.accountId,
                passwordEncoder.encode(request.password),
                request.name,
                request.phoneNumber
            )
        )
    }

}