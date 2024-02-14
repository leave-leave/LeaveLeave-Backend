package com.example.leaveleave.domain.plan.presentation

import com.example.leaveleave.domain.plan.presentation.dto.request.PlanTodoListRequest
import com.example.leaveleave.domain.plan.service.PlanService
import org.springframework.http.HttpStatus
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
    private val planService: PlanService,
) {
    @PostMapping("/{plan-id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun createTodo(@PathVariable("plan-id") planId: Long, @RequestBody planTodoListRequest: PlanTodoListRequest) {
        val responses = planTodoListRequest.todo.map { planTodoRequest ->
            planService.addTodo(
                planId,
                planTodoRequest.detailContent,
                planTodoRequest.todoId
            )
        }
    }

    @DeleteMapping("/{todo-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTodo(@PathVariable("todo-id") todoId: Long) {
        return planService.deleteTodo(todoId)
    }
}