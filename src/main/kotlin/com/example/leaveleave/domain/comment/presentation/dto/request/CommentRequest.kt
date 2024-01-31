package com.example.leaveleave.domain.comment.presentation.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.Size

data class CommentRequest(
    @field:Size(min = 1, max = 100, message = "댓글은 최소 1자 ~ 100자 까지 작성 가능합니다.")
    @JsonProperty("comment")
    val comment: String
)