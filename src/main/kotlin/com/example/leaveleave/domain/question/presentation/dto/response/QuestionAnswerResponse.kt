package com.example.leaveleave.domain.question.presentation.dto.response

import com.example.leaveleave.domain.question.domain.QuestionAnswer
import com.example.leaveleave.domain.question.presentation.dto.request.QuestionAnswerPair
import com.example.leaveleave.domain.question.presentation.dto.request.QuestionAnswerRequest
import com.example.leaveleave.domain.user.domain.User

data class QuestionAnswerResponse(
    val accountId: User,
    val answers: List<QuestionAnswerPair>?
){
    companion object{
        fun format(questionAnswerRequest: List<QuestionAnswerPair>?, accountId: User): QuestionAnswerResponse{
            return QuestionAnswerResponse(
                accountId = accountId,
                answers = questionAnswerRequest,
            )
        }
    }
}

