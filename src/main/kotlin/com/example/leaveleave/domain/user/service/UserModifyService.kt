package com.example.leaveleave.domain.user.service

import com.example.leaveleave.domain.user.domain.repository.UserRepository
import com.example.leaveleave.domain.user.facade.UserFacade
import com.example.leaveleave.domain.user.presentation.dto.request.UpdateModifyRequest
import org.springframework.stereotype.Service

@Service
class UserModifyService(
    private val userFacade: UserFacade,
    private val userRepository: UserRepository
) {
    fun userModify(request: UpdateModifyRequest) {
        val user = userFacade.getCurrentUser()
        user.updateModify(request.name, request.phoneNumber)

        userRepository.save(user)
    }
}