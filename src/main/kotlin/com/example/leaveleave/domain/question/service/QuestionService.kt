package com.example.leaveleave.domain.question.service

import com.example.leaveleave.domain.question.domain.Question
import com.example.leaveleave.domain.question.domain.QuestionAnswer
import com.example.leaveleave.domain.question.domain.repository.QuestionAnswerRepository
import com.example.leaveleave.domain.question.domain.repository.QuestionRepository
import com.example.leaveleave.domain.question.presentation.dto.request.QuestionAnswerRequest
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class QuestionService(
    private val questionRepository: QuestionRepository,
    private val questionAnswerRepository: QuestionAnswerRepository,
) {
    fun getQuestion(): List<Question> {
        return questionRepository.findAll()
    }

    fun postQuestionAnswer(questionAnswerRequest: QuestionAnswerRequest){
        val questionAnswer = QuestionAnswer(
            questionAnswerRequest.user,
            questionAnswerRequest.questionAnswer,
            questionAnswerRequest.accountId,
            questionAnswerRequest.question
        )
        questionAnswerRepository.save(questionAnswer)
    }

    fun getQuestionAnswer(): MutableList<QuestionAnswer> {
        return questionAnswerRepository.findAll()
    }
}