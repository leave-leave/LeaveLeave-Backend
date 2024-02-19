package com.example.leaveleave.domain.question.domain.repository

import com.example.leaveleave.domain.question.domain.Question
import com.example.leaveleave.domain.question.domain.QuestionAnswer
import com.example.leaveleave.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionAnswerRepository : JpaRepository<QuestionAnswer, Long> {
}