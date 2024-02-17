package com.example.leaveleave.domain.question.domain.repository

import com.example.leaveleave.domain.question.domain.QuestionAnswer
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionAnswerRepository : JpaRepository<QuestionAnswer,Long>{

}