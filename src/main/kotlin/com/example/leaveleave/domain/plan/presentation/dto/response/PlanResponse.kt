package com.example.leaveleave.domain.plan.presentation.dto.response

import com.example.leaveleave.domain.plan.domain.Plan
import com.example.leaveleave.domain.plan.domain.PlanTodoList
import com.example.leaveleave.domain.plan.presentation.dto.request.PlanTodoRequest
import com.example.leaveleave.domain.user.domain.User
import java.time.ZonedDateTime

data class PlanResponse(
    val id: Long?,
    val startDate: ZonedDateTime,
    val endDate: ZonedDateTime,
    val title: String,
    val detailContent : String

) {
    companion object {
        fun fromEntity(plan: Plan, planTodoList: PlanTodoList): PlanResponse {
            return PlanResponse(
                id = plan.id,
                startDate = plan.startDate,
                endDate = plan.endDate,
                title = plan.title,
                detailContent = planTodoList.detailContent
            )
        }
    }
}