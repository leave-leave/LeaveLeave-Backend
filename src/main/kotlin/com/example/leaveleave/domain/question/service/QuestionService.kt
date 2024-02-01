package com.example.leaveleave.domain.question.service

import com.example.leaveleave.domain.question.domain.repository.QuestionRepository
import com.example.leaveleave.domain.question.presentation.dto.response.QuestionResponse
import org.springframework.stereotype.Service

@Service
class QuestionService(
    private val questionRepository: QuestionRepository
) {
    fun getQuestion(questionId: Long): QuestionResponse {
        val question = questionRepository.findById(questionId)
            .orElseThrow { RuntimeException("찾을 수 없습니다.") }

        return QuestionResponse(question.question)
    }
}