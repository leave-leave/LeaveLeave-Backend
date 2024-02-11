package com.example.leaveleave.domain.question.presentation

import com.example.leaveleave.domain.question.domain.Question
import com.example.leaveleave.domain.question.service.QuestionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class QuestionController(
    private val questionService: QuestionService
) {
    @GetMapping("/question")
    fun getQuestion(): List<Question> {
        return questionService.getQuestion()
    }

}