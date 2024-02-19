package com.example.leaveleave.domain.question.domain

import com.example.leaveleave.domain.user.domain.User
import javax.persistence.*

@Entity(name = "tbl_question_answer")
class QuestionAnswer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Column(name = "question_answer" , columnDefinition = "boolean")
    val questionAnswer: Boolean,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    var user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    var question: Question,

    )