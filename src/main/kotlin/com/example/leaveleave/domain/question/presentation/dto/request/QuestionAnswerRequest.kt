package com.example.leaveleave.domain.question.presentation.dto.request


data class QuestionAnswerPair(
    val questionId: Long,
    val questionAnswer: Boolean,
)

data class QuestionAnswerRequest(
    val answers: List<QuestionAnswerPair>?,
)