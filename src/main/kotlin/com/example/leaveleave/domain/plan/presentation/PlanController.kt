package com.example.leaveleave.domain.plan.presentation

import com.example.leaveleave.domain.plan.domain.Plan
import com.example.leaveleave.domain.plan.exception.PlanNotFoundException
import com.example.leaveleave.domain.plan.presentation.dto.request.PlanRequest
import com.example.leaveleave.domain.plan.presentation.dto.response.PlanResponse
import com.example.leaveleave.domain.plan.service.PlanService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/plans")
class PlanController (
    private val planService: PlanService
) {
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun addPlan(@RequestBody planRequest: PlanRequest) {
        return planService.savePlan(planRequest.userId ,planRequest.startDate, planRequest.endDate, planRequest.title)
    }

    @GetMapping("/{plan-id}")
    @ResponseStatus(HttpStatus.OK)
    fun getPlan(@PathVariable("plan-id") planId: Long) : ResponseEntity<PlanResponse> {
        try {
            val plan = planService.getPlanById(planId)
        } catch (ex: PlanNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)
        }

        return TODO("Provide the return value")
    }


    @DeleteMapping("/{plan-id}")
    @ResponseStatus(HttpStatus.OK)
    fun deletePlan(@PathVariable ("plan-id") planId: Long){
        planService.deletePlan(planId)
    }
}