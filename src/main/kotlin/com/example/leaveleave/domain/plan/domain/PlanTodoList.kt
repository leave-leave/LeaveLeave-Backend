package com.example.leaveleave.domain.plan.domain

import javax.persistence.*

@Entity(name = "tbl_todo_list")
class PlanTodoList(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Column(columnDefinition = "VARCHAR(40)", nullable = false)
    var detailContent: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    var plan: Plan
) {
    constructor(detailContent: String, plan: Plan) : this(0, detailContent =  detailContent, plan)
}