package com.example.leaveleave.domain.question.presentation.dto.request

import com.fasterxml.jackson.annotation.JsonProperty


data class QuestionAnswerPair(
    val questionId: Long,
    @JsonProperty("questionAnswer")
    val questionAnswer: Boolean,
)

data class QuestionAnswerRequest(
    val answers: List<QuestionAnswerPair>? = emptyList()
)