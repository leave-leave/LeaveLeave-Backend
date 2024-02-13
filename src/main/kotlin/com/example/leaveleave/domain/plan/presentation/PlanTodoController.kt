package com.example.leaveleave.domain.plan.presentation

import com.example.leaveleave.domain.plan.domain.PlanTodoList
import com.example.leaveleave.domain.plan.presentation.dto.request.PlanTodoRequest
import com.example.leaveleave.domain.plan.presentation.dto.response.PlanTodoListResponse
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
@RequestMapping("/todo")
class PlanTodoController(
    private val planService: PlanService
) {
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun createTodo(@RequestBody planTodoRequest: PlanTodoRequest) {
        planService.addTodo(
            detailContent = planTodoRequest.detailContent,
            planId = planTodoRequest.planId,
            todoId = planTodoRequest.todoId
        )
    }

    @GetMapping("{plan-id}")
    @ResponseStatus(HttpStatus.OK)
    fun getTodoList(@PathVariable("plan-id") planId: Long) {
        planService.getTodoPlanId(planId)
    }

    @DeleteMapping("/{todo-id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteTodo(@PathVariable("todo-id") todoId: Long) {
        return planService.deleteTodo(todoId)
    }
}