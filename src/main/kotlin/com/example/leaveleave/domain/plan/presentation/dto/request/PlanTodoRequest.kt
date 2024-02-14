package com.example.leaveleave.domain.plan.presentation.dto.request

import com.fasterxml.jackson.annotation.JsonProperty

data class PlanTodoRequest(
    @JsonProperty("detailContent")
    val detailContent: String,
    val planId : Long,
    val todoId: Long
)

data class PlanTodoListRequest(
     val todo : List<PlanTodoRequest> = emptyList()
)