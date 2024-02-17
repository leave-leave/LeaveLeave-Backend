package com.example.leaveleave.domain.question.domain

import com.example.leaveleave.domain.like.domain.Like
import javax.persistence.*

@Entity(name = "tbl_question_answer")
class QuestionAnswer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    val questionAnswer: Boolean,

    @OneToMany(mappedBy = "question", cascade = [CascadeType.ALL], orphanRemoval = true)
    val questionId: MutableList<Like> = mutableListOf(),

    @OneToMany(mappedBy = "question", cascade = [CascadeType.ALL], orphanRemoval = true)
    val accountId: MutableList<Like> = mutableListOf(),
    )