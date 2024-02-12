package com.example.leaveleave.domain.plan.presentation

import com.example.leaveleave.domain.plan.service.PlanTodoService
import com.example.leaveleave.domain.user.domain.User
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todo")
class PlanTodoController(
    private val todoService: PlanTodoService
) {
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun addTodoPlan(@RequestParam planId: Long,  @RequestParam detailContent: String) {
        return todoService.addTodoPlan(planId, detailContent)
    }

    @DeleteMapping("/{todo-id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteTodo(@PathVariable("todo-id") todoId: Long) {
        return todoService.deleteTodo(todoId)
    }
}