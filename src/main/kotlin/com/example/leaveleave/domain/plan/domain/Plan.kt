package com.example.leaveleave.domain.plan.domain

import com.example.leaveleave.domain.user.domain.User
import java.time.LocalDateTime
import javax.persistence.*


@Entity(name = "tbl_plan")
class Plan (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    var user: User? = null,

    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    var startDate: LocalDateTime? = null,

    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    var endDate: LocalDateTime? = null,

    @Column(name = "title")
    var title: String? = null

){
    fun save(user: User, startDate: LocalDateTime, endDate: LocalDateTime){
        this.user = user
        this.startDate = startDate
        this.endDate = endDate
        this.title = title
    }
}