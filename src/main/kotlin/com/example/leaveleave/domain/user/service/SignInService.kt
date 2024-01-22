package com.example.leaveleave.domain.user.service

import com.example.leaveleave.domain.user.exception.IncorrectPasswordException
import com.example.leaveleave.domain.user.facade.UserFacade
import com.example.leaveleave.domain.user.presentation.dto.request.SignUpRequest
import com.example.leaveleave.domain.user.presentation.dto.response.TokenResponse
import com.example.leaveleave.global.security.jwt.TokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.transaction.annotation.Transactional
import org.springframework.stereotype.Service

@Service
class SignInService(
    private val userFacade: UserFacade,
    private val passwordEncoder: PasswordEncoder,
    private val tokenProvider: TokenProvider,
){
    @Transactional
    fun execute(request: SignUpRequest): TokenResponse{
        val user = userFacade.getByAccountId(request.accountId)
        if(!passwordEncoder.matches(request.password, user.password)){
            throw IncorrectPasswordException
        }
        return tokenProvider.generateToken(user.accountId)
    }
}