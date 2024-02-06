package com.example.leaveleave.domain.plan.presentation.dto.request

import com.example.leaveleave.domain.plan.domain.Plan

data class PlanTodoRequest(
    val id: Long,
    val detailContent : String,
    val plan: Plan
)