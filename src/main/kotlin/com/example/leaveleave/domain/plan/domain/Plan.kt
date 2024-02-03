package com.example.leaveleave.domain.plan.domain

import com.example.leaveleave.domain.user.domain.User
import javax.persistence.*


@Entity(name = "tbl_plan")
class Plan (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    var user: User? = null

    
){
    fun save(user: User){
        this.user = user
    }
}