package com.example.leaveleave.global.error

import com.example.leaveleave.global.error.exception.LeaveLeaveException

class ErrorResponse(
    val status: Int,
    val message: String,
) {
    companion object{
        fun of(e : LeaveLeaveException) : ErrorResponse {
            return ErrorResponse(e.status, e.message)
        }
    }
}