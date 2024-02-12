package com.example.leaveleave.domain.plan.service

import com.example.leaveleave.domain.plan.domain.Plan
import com.example.leaveleave.domain.plan.domain.PlanTodoList
import com.example.leaveleave.domain.plan.domain.repository.PlanRepository
import com.example.leaveleave.domain.plan.domain.repository.PlanTodoRepository
import com.example.leaveleave.domain.plan.exception.PlanNotFoundException
import com.example.leaveleave.domain.plan.presentation.dto.request.PlanRequest
import com.example.leaveleave.domain.plan.presentation.dto.request.PlanTodoRequest
import com.example.leaveleave.domain.user.facade.UserFacade
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class PlanService(
    private val planRepository: PlanRepository,
    private val userFacade: UserFacade,
    private val planTodoRepository: PlanTodoRepository,
) {
    fun addPlan(planRequest: PlanRequest) {
        val user = userFacade.getCurrentUser()

        val newPlan = Plan(
            id =  planRequest.planId,
            user = user,
            title = planRequest.title,
            startDate = planRequest.startDate,
            endDate = planRequest.endDate
        )
        val savedPlan = planRepository.save(newPlan)

        planRequest.todos.forEach { todo ->
            val newTodoPlan = PlanTodoList(detailContent = todo.detailContent, plan = savedPlan)
            planTodoRepository.save(newTodoPlan)
        }
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

    fun deleteTodo(todoId: Long) {
        planTodoRepository.deleteById(todoId)
    }
}


