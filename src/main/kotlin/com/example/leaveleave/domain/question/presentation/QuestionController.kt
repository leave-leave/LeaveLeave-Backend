package com.example.leaveleave.domain.question.presentation

import com.example.leaveleave.domain.question.domain.Question
import com.example.leaveleave.domain.question.domain.QuestionAnswer
import com.example.leaveleave.domain.question.presentation.dto.request.QuestionAnswerRequest
import com.example.leaveleave.domain.question.service.QuestionService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/question")
class QuestionController(
    private val questionService: QuestionService
) {
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    fun getQuestion(): List<Question> {
        return questionService.getQuestion()
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun postQuestionAnswer(@RequestBody questionAnswerRequest: QuestionAnswerRequest){
        return questionService.postQuestionAnswer(questionAnswerRequest)
    }

    @GetMapping("/answer")
    @ResponseStatus(HttpStatus.OK)
    fun getQuestionAnswer(): MutableList<QuestionAnswer>{
        return questionService.getQuestionAnswer()
    }
}