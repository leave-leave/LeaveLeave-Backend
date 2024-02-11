package com.example.leaveleave.domain.plan.domain

import com.example.leaveleave.domain.user.domain.User
import java.time.LocalDateTime
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
    var startDate: LocalDateTime,

    @Column(name = "end_date")
    var endDate: LocalDateTime,

    @Column(name = "title")
    var title: String

) {
    fun save(user: User, startDate: LocalDateTime, endDate: LocalDateTime, title: String) {
        this.startDate = startDate
        this.endDate = endDate
        this.title = title
    }
}