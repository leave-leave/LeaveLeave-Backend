package com.example.leaveleave.global.error

import com.example.leaveleave.global.error.exception.LeaveLeaveException
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.valueOf
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.http.HttpStatus


@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(LeaveLeaveException::class)
    fun customExceptionHandling(e: LeaveLeaveException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse.of(e), HttpStatus.valueOf(e.status))
    }

    @ExceptionHandler(BindException::class)
    fun handleBindException(e: BindException): ResponseEntity<Map<String, String?>> {
        val errorMap: MutableMap<String, String?> = HashMap()
        for (error in e.fieldErrors) {
            errorMap[error.field] = error.defaultMessage
        }
        return ResponseEntity<Map<String, String?>>(errorMap, BAD_REQUEST)
    }
}