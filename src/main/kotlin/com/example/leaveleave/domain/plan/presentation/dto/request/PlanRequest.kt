package com.example.leaveleave.domain.plan.presentation.dto.request

import com.example.leaveleave.domain.plan.presentation.dto.response.PlanTodoResponse
import com.example.leaveleave.domain.user.domain.User
import java.time.LocalDateTime

data class PlanRequest(
    val userId: String,
    val planId: Long,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
    val title: String,
    val detailContent: String,
    val todos: List<PlanTodoRequest>
)

data class PlanTodoRequest(
    val detailContent: String
)