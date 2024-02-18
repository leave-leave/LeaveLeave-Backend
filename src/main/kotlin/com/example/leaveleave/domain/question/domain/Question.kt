package com.example.leaveleave.domain.question.domain

import com.example.leaveleave.domain.user.domain.User
import javax.persistence.*


@Entity(name = "tbl_question")
data class Question(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val questionId: Long,

    @Column(columnDefinition = "varchar(255)")
    val question: String,

    @OneToMany(mappedBy = "questionAnswer", cascade = [CascadeType.ALL], orphanRemoval = true)
    val questionAnswer: MutableList<QuestionAnswer> = mutableListOf(),
)