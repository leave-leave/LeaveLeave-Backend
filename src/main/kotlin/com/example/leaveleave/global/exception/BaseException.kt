package com.example.leaveleave.global.exception

abstract class BaseException : RuntimeException() {
    abstract fun getExceptionType(): BaseExceptionType
}