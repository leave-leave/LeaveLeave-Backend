package com.example.leaveleave.domain.plan.domain.repository

import com.example.leaveleave.domain.plan.domain.Plan
import com.example.leaveleave.domain.plan.domain.PlanTodoList
import org.springframework.data.jpa.repository.JpaRepository

interface PlanTodoRepository:JpaRepository<PlanTodoList,Long> {
    fun findByPlan(plan: Plan): List<PlanTodoList>
}