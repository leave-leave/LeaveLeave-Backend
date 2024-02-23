package com.example.leaveleave.domain.feed.presentation.dto.request

import javax.validation.constraints.Size

data class UpdateFeedRequest(
    @field:Size(max = 50, message = "50자까지 가능합니다.")
    val title: String,

    @field:Size(max = 500, message = "500자까지 가능합니다.")
    val content: String,

    @field:Size(max = 200, message = "200자까지 가능합니다.")
    val imageUrl: String
)