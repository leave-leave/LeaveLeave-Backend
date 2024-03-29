package com.example.leaveleave.domain.plan.presentation

import com.example.leaveleave.domain.plan.presentation.dto.request.PlanRequest
import com.example.leaveleave.domain.plan.presentation.dto.response.PlanResponse
import com.example.leaveleave.domain.plan.service.PlanService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/plans")
class PlanController(
    private val planService: PlanService,
) {
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun addPlan(@RequestBody planRequest: PlanRequest) {
        planService.addPlan(planRequest)
        // plan과 todo 배열로 받기
    }

    @GetMapping("/{plan-id}")
    @ResponseStatus(HttpStatus.OK)
    fun getPlan(@PathVariable("plan-id") planId: Long): PlanResponse{
        return planService.getPlanAndTodoListById(planId)

    }

    @DeleteMapping("/{plan-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePlan(@PathVariable("plan-id") planId: Long) {
        planService.deletePlan(planId)
    }
}