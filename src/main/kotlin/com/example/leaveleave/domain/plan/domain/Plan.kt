package com.example.leaveleave.domain.plan.domain

import com.example.leaveleave.domain.comment.domain.Comment
import com.example.leaveleave.domain.user.domain.User
import java.time.LocalDateTime
import java.time.ZonedDateTime
import javax.persistence.*


@Entity(name = "tbl_plan")
class Plan(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User,

    @Column(name = "start_date")
    var startDate: ZonedDateTime,

    @Column(name = "end_date")
    var endDate: ZonedDateTime,

    @Column(name = "title")
    var title: String,

    @OneToMany(mappedBy = "plan", cascade = [CascadeType.ALL], orphanRemoval = true)
    val planTodoList: MutableList<Plan> = mutableListOf(),
) {
    fun save(user: User, startDate: ZonedDateTime, endDate: ZonedDateTime, title: String) {
        this.startDate = startDate
        this.endDate = endDate
        this.title = title
    }
}