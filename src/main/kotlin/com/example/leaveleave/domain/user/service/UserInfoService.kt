package com.example.leaveleave.domain.user.service

import com.example.leaveleave.domain.user.facade.UserFacade
import com.example.leaveleave.domain.user.presentation.dto.response.UserInfoResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserInfoService(
    private val userFacade: UserFacade,
) {
    @Transactional(readOnly = true)
    fun execute(): UserInfoResponse{
        val user = userFacade.getCurrentUser()
        return UserInfoResponse(user.accountId, user.name)
    }
}