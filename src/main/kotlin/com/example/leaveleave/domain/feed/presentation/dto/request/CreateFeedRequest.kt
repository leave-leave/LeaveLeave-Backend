package com.example.leaveleave.domain.feed.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class CreateFeedRequest(
    @field:NotBlank(message = "null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Size(max = 20, message = "20자까지 가능합니다.")
    val title: String,

    @field:NotNull(message = "null 허용하지 않습니다.")
    @field:Size(max = 500, message = "500자까지 가능합니다.")
    val content: String,
)