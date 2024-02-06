package com.example.leaveleave.domain.plan.presentation.dto.request

import com.example.leaveleave.domain.user.domain.User
import java.time.LocalDateTime

data class PlanRequest(
    val userId: User,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
    val title: String
)