package com.example.leaveleave.domain.user.service

import com.example.leaveleave.domain.user.domain.repository.UserRepository
import com.example.leaveleave.domain.user.facade.UserFacade
import com.example.leaveleave.domain.user.presentation.dto.request.UpdatePasswordRequest
import org.springframework.stereotype.Service

@Service
class UpdatePasswordService(
    private val userFacade: UserFacade,
    private val userRepository: UserRepository
){
    fun updatePassword(request: UpdatePasswordRequest){
        val user = userFacade.getCurrentUser()
        user.updatePassword(request.password)

        userRepository.save(user)
    }
}