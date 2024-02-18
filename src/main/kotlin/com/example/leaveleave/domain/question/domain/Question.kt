package com.example.leaveleave.domain.question.domain

import com.example.leaveleave.domain.user.domain.User
import javax.persistence.*


@Entity(name = "tbl_question")
data class Question(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(columnDefinition = "varchar(255)")
    val question: String,

    @OneToMany(mappedBy = "question", cascade = [CascadeType.ALL], orphanRemoval = true)
    val questionAnswer: MutableList<QuestionAnswer> = mutableListOf(),
)