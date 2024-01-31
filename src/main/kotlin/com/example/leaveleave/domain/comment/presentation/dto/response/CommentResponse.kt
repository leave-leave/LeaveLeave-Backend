package com.example.leaveleave.domain.comment.presentation.dto.response

import java.time.LocalDateTime

class CommentResponse(
    val id: Long,
    val comment: String?,
    val createAt: LocalDateTime
) {
}