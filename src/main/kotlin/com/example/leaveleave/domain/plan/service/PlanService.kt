package com.example.leaveleave.domain.plan.service

import com.example.leaveleave.domain.plan.domain.Plan
import com.example.leaveleave.domain.plan.domain.PlanTodoList
import com.example.leaveleave.domain.plan.domain.repository.PlanRepository
import com.example.leaveleave.domain.plan.domain.repository.PlanTodoRepository
import com.example.leaveleave.domain.plan.exception.PlanNotFoundException
import com.example.leaveleave.domain.plan.exception.PlanTodoListNotFoundException
import com.example.leaveleave.domain.plan.presentation.dto.request.PlanRequest
import com.example.leaveleave.domain.plan.presentation.dto.response.PlanTodoListResponse
import com.example.leaveleave.domain.user.facade.UserFacade
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import java.util.NoSuchElementException
import javax.transaction.Transactional

@Service
class PlanService(
    private val planRepository: PlanRepository,
    private val userFacade: UserFacade,
    private val planTodoRepository: PlanTodoRepository,
) {
    fun addPlan(planRequest: PlanRequest) {
        val user = userFacade.getCurrentUser()

        val newPlan = Plan(
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

    fun getPlanById(planId: Long): Plan {
        return planRepository.findById(planId).orElseThrow {
            NoSuchElementException("Plan with ID $planId not found")
        }
    }

    fun getTodoPlanId(planId: Long): PlanTodoList {
        return planTodoRepository.getAllByPlanId(planId).firstOrNull()
            ?: throw PlanTodoListNotFoundException("계획을 찾을 수 없음")
    }

    fun deletePlan(planId: Long) {
        val exists = planRepository.existsById(planId)
        if (!exists) {
            throw PlanNotFoundException("계획을 찾을 수 없음 $planId")
        }
        planRepository.deleteById(planId)
    }

    fun addTodo(planId: Long, detailContent: String, todoId: Long): PlanTodoListResponse {
        val plan = planRepository.findById(planId).orElseThrow {
            NoSuchElementException("계획 아이디가 존재하지 않음 $planId")
        }
        val todo = PlanTodoList(detailContent = detailContent, plan = plan)

        val savedTodo = planTodoRepository.save(todo)
        return PlanTodoListResponse.fromEntity(savedTodo)
    }

    fun deleteTodo(todoId: Long) {
        planTodoRepository.deleteById(todoId)
    }
}


