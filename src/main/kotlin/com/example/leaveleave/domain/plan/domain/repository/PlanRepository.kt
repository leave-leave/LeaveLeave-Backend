package com.example.leaveleave.domain.plan.domain.repository

import com.example.leaveleave.domain.plan.domain.Plan
import org.springframework.data.jpa.repository.JpaRepository

interface PlanRepository : JpaRepository<Plan, Long> {
}