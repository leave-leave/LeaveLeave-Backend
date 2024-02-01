package com.example.leaveleave.domain.question.service

import com.example.leaveleave.domain.question.domain.Question
import com.example.leaveleave.domain.question.domain.repository.QuestionRepository
import org.springframework.stereotype.Service

@Service
class QuestionService(
    private val questionRepository: QuestionRepository
) {
    fun getQuestion(): List<Question> {
        return questionRepository.findAll()
    }
}