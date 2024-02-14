package com.example.leaveleave.domain.plan.presentation.dto.response

import com.example.leaveleave.domain.plan.domain.PlanTodoList

class TodoResponse(
    val detailContent: String,
    val planId: Long?,
    val todoId : Long?
) {
    companion object {
        fun fromEntity(planTodoList: PlanTodoList): TodoResponse {
            return TodoResponse(
                detailContent = planTodoList.detailContent,
                planId = planTodoList.plan.id,
                todoId = planTodoList.id
            )
        }
    }
}