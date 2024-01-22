package com.example.leaveleave.global.error.exception

import com.example.leaveleave.global.error.exception.ErrorCode

abstract class LeaveLeaveException(
    val errorCode: ErrorCode,
) : RuntimeException() {
    val status: Int
        get() = errorCode.status
    override val message: String
        get() = errorCode.message
}