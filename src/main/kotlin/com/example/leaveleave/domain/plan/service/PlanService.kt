package com.example.leaveleave.domain.plan.service

import com.example.leaveleave.domain.plan.domain.Plan
import com.example.leaveleave.domain.plan.domain.PlanTodoList
import com.example.leaveleave.domain.plan.domain.repository.PlanRepository
import com.example.leaveleave.domain.plan.exception.PlanNotFoundException
import com.example.leaveleave.domain.plan.presentation.dto.request.PlanRequest
import com.example.leaveleave.domain.user.domain.User
import com.example.leaveleave.domain.user.facade.UserFacade
import com.example.leaveleave.domain.user.service.UserInfoService
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import java.time.LocalDateTime

@Service
class PlanService(
    private val planRepository: PlanRepository,
    private val userFacade: UserFacade,
) {
    fun addPlan(@RequestBody request: PlanRequest) {
        val user = userFacade.getCurrentUser()
    }

    fun getPlanById(planId: Long): Plan = planRepository.findById(planId).orElseThrow {
        PlanNotFoundException("계획을 찾을 수 없음 $planId")
    }

    fun deletePlan(planId: Long) {
        try {
            planRepository.deleteById(planId)
        } catch (e: EmptyResultDataAccessException) {
            throw PlanNotFoundException("계획을 찾을 수 없음 $planId")
        }
    }
}


