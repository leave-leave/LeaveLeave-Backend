package com.example.leaveleave.domain.question.service

import com.example.leaveleave.domain.question.domain.Question
import com.example.leaveleave.domain.question.domain.QuestionAnswer
import com.example.leaveleave.domain.question.domain.repository.QuestionAnswerRepository
import com.example.leaveleave.domain.question.domain.repository.QuestionRepository
import com.example.leaveleave.domain.question.presentation.dto.request.QuestionAnswerRequest
import com.example.leaveleave.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class QuestionService(
    private val questionRepository: QuestionRepository,
    private val questionAnswerRepository: QuestionAnswerRepository,
    private val userFacade: UserFacade
) {
    fun getQuestion(): List<Question> {
        return questionRepository.findAll()
    }

    @Transactional
    fun postQuestionAnswer(questionAnswerRequest: QuestionAnswerRequest) {
        val user = userFacade.getCurrentUser()
        questionAnswerRequest.answers?.map { answer ->
            val question = questionRepository.getQuestionById(answer.questionId)
            questionAnswerRepository.save(
                QuestionAnswer(
                    0,
                    user = user,
                    questionAnswer = answer.questionAnswer,
                    question = question
                )
            )
        }
    }

    fun getQuestionAnswer(): MutableList<QuestionAnswer> {
        return questionAnswerRepository.findAll()
    }
}