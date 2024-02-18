package com.example.leaveleave.domain.question.domain

import com.example.leaveleave.domain.plan.domain.Plan
import com.example.leaveleave.domain.user.domain.User
import javax.persistence.*

@Entity(name = "tbl_question_answer")
class QuestionAnswer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    val questionAnswer: Boolean,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    var accountId: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    var question: Question
) {
    constructor(questionAnswer: Boolean, accountId: User, question: Question) : this(
        0,
        questionAnswer = true,
        accountId,
        question
    )
}