package com.example.leaveleave.domain.question.domain.repository

import com.example.leaveleave.domain.question.domain.Question
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionRepository : JpaRepository<Question, Long> {
    fun getQuestionById(questionId: Long): Question
}