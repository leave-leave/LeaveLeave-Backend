package com.example.leaveleave.domain.plan.service

import com.example.leaveleave.domain.plan.domain.Plan
import com.example.leaveleave.domain.plan.domain.repository.PlanRepository
import com.example.leaveleave.domain.plan.exception.PlanNotFoundException
import com.example.leaveleave.domain.user.domain.User
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class PlanService(
    private val planRepository: PlanRepository
) {
    fun savePlan(user: User, startDate: LocalDateTime, endDate: LocalDateTime, title: String) {
        val plan = Plan(user = user, startDate = startDate, endDate = endDate, title = title)
        planRepository.save(plan)
    }

    fun getPlanById(planId: Long): Plan {
        return planRepository.findById(planId).orElseThrow { PlanNotFoundException("$planId not found") }
    }

    fun deletePlan(planId: Long) {
        try {
            planRepository.deleteById(planId)
        } catch (ex: EmptyResultDataAccessException) {
            throw PlanNotFoundException("$planId not found")
        }
    }
}