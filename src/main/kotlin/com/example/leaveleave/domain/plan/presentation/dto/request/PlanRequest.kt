package com.example.leaveleave.domain.plan.presentation.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.ZonedDateTime

data class PlanRequest(
    val id : Long,
    val userId: String,
    val startDate: ZonedDateTime,
    val endDate: ZonedDateTime,
    @JsonProperty("title")
    val title: String,
)