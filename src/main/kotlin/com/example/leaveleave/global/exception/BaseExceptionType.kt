package com.example.leaveleave.global.exception

import com.example.leaveleave.global.error.exception.ErrorCode
import org.springframework.http.HttpStatus

interface BaseExceptionType {
    fun ErrorCode(): Int
    fun HttpStatus(): HttpStatus
    fun getErrorMessage(): String
}