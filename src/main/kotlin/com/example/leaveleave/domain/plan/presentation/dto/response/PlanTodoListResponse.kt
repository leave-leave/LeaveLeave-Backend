package com.example.leaveleave.domain.plan.presentation.dto.response

import com.example.leaveleave.domain.plan.domain.Plan
import com.example.leaveleave.domain.plan.domain.PlanTodoList

class PlanTodoListResponse(
    val detailContent: String,
    val planId: Long?,
    val todoId : Long?
) {
    companion object {
        fun fromEntity(planTodoList: PlanTodoList): PlanTodoListResponse {
            return PlanTodoListResponse(
                detailContent = planTodoList.detailContent,
                planId = planTodoList.plan.id,
                todoId = planTodoList.id
            )
        }
    }
}