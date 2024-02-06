package com.example.leaveleave.domain.plan.presentation.dto.response

import com.example.leaveleave.domain.plan.domain.Plan
import com.example.leaveleave.domain.user.domain.User
import com.example.leaveleave.domain.user.presentation.dto.response.UserInfoResponse
import java.time.LocalDateTime

data class PlanResponse(
    val id: Long?,
    val userId: User,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
    val title: String
) {
    companion object{
        fun fromEntity(plan: Plan) : PlanResponse{
            return PlanResponse(
                id = plan.id,
                userId = plan.user,
                startDate =  plan.startDate,
                endDate = plan.endDate,
                title = plan.title
            )
        }
    }
}