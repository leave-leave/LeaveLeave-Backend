package com.example.leaveleave.domain.plan.service

import com.example.leaveleave.domain.plan.domain.Plan
import com.example.leaveleave.domain.plan.domain.PlanTodoList
import com.example.leaveleave.domain.plan.domain.repository.PlanTodoRepository
import org.springframework.stereotype.Service

@Service
class PlanTodoService(
    private val planTodoRepository: PlanTodoRepository,
    private val planService: PlanService
) {
    fun addTodoPlan(planId: Long, detailContent: String) {
        val plan: Plan = planService.getPlanById(planId) ?: throw IllegalArgumentException("plan not found")

        val todo = PlanTodoList(detailContent = detailContent, plan = plan)
        planTodoRepository.save(todo)
    }

    fun getTodosForPlan(planId: Long): List<PlanTodoList>{
        val plan : Plan = planService.getPlanById(planId) ?: throw IllegalArgumentException("plan not found")

        return planTodoRepository.findByPlan(plan)
    }

    fun deleteTodo(todoId: Long){
        planTodoRepository.deleteById(todoId)
    }
}