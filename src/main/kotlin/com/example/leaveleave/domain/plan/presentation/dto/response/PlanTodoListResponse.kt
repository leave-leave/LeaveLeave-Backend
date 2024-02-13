package com.example.leaveleave.domain.plan.presentation.dto.response

import com.example.leaveleave.domain.plan.domain.Plan
import com.example.leaveleave.domain.plan.domain.PlanTodoList

class PlanTodoListResponse(
    val detailContent: String,
    val plan: Plan
) {
    companion object {
        fun fromEntity(planTodoList: PlanTodoList): PlanTodoListResponse {
            return PlanTodoListResponse(
                detailContent = planTodoList.detailContent,
                plan = planTodoList.plan
            )
        }
    }
}