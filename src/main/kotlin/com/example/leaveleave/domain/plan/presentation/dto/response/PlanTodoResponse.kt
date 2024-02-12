package com.example.leaveleave.domain.plan.presentation.dto.response

import com.example.leaveleave.domain.plan.domain.Plan
import com.example.leaveleave.domain.plan.domain.PlanTodoList

data class PlanTodoResponse(
    val detailContent: String,
    val plan: Plan
) {
    companion object {
        fun fromEntity(planTodoList: PlanTodoList): PlanTodoResponse {
            return PlanTodoResponse(
                detailContent = planTodoList.detailContent,
                plan = planTodoList.plan
            )
        }
    }
}