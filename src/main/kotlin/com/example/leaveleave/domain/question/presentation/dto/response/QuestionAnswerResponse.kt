package com.example.leaveleave.domain.question.presentation.dto.response

data class QuestionAnswerResponse(
    val accountId: Long,
    val questionId: Long,
    val answer: Boolean,
)

