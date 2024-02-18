package com.example.leaveleave.domain.question.presentation.dto.request

import com.example.leaveleave.domain.question.domain.Question
import com.example.leaveleave.domain.user.domain.User

data class QuestionAnswerRequest (
    val user: Long,
    val questionAnswer: Boolean,
    val accountId: User,
    val question: Question
)