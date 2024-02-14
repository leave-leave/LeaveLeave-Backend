package com.example.leaveleave.domain.plan.presentation.dto.response

import com.example.leaveleave.domain.plan.domain.Plan
import com.example.leaveleave.domain.plan.domain.PlanTodoList
import com.example.leaveleave.domain.plan.presentation.dto.request.PlanTodoRequest
import com.example.leaveleave.domain.user.domain.User
import java.time.ZonedDateTime

data class PlanResponse(
    val planId: Long,
    val startDate: ZonedDateTime,
    val endDate: ZonedDateTime,
    val title: String,
    val todoList: List<String>

) {
    companion object {
        fun fromEntity(plan: Plan, todoList: List<PlanTodoList>): PlanResponse {
            return PlanResponse(
                planId = plan.id,
                startDate = plan.startDate,
                endDate = plan.endDate,
                title = plan.title,
                todoList = todoList.map { todo -> todo.detailContent }
            )
        }
    }
}