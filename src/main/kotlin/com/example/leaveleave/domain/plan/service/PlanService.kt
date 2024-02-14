package com.example.leaveleave.domain.plan.service

import com.example.leaveleave.domain.plan.domain.Plan
import com.example.leaveleave.domain.plan.domain.PlanTodoList
import com.example.leaveleave.domain.plan.domain.repository.PlanRepository
import com.example.leaveleave.domain.plan.domain.repository.PlanTodoRepository
import com.example.leaveleave.domain.plan.presentation.dto.request.PlanRequest
import com.example.leaveleave.domain.plan.presentation.dto.response.PlanResponse
import com.example.leaveleave.domain.plan.presentation.dto.response.TodoResponse
import com.example.leaveleave.domain.user.facade.UserFacade
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
            id = planRequest.id,
            user = user,
            title = planRequest.title,
            startDate = planRequest.startDate,
            endDate = planRequest.endDate
        )
        val savedPlan = planRepository.save(newPlan)
    }

    fun getPlanAndTodoListById(planId: Long): PlanResponse{
        val plan = planRepository.findById(planId).orElseThrow{
            NoSuchElementException("계획을 찾을 수 없음 $planId")
        }
        val todoList = planTodoRepository.findAllByPlanId(planId)
        println(PlanResponse.fromEntity(plan,todoList))
        return PlanResponse.fromEntity(plan,todoList)
    }


    fun deletePlan(planId: Long) {
        planTodoRepository.getAllByPlanId(planId)
        planRepository.deleteById(planId)
    }

    @Transactional
    fun addTodo(planId: Long, detailContent: String, todoId: Long): TodoResponse {
        val plan = planRepository.findById(planId).orElseThrow {
            NoSuchElementException("계획 아이디가 존재하지 않음 $planId")
        }
        val todo = PlanTodoList(detailContent = detailContent, plan = plan)

        val savedTodo = planTodoRepository.save(todo)
        return TodoResponse.fromEntity(savedTodo)
    }

    fun deleteTodo(todoId: Long) {
        planTodoRepository.deleteById(todoId)
    }
}


