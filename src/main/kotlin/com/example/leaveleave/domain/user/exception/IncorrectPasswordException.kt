package com.example.leaveleave.domain.user.exception

import com.example.leaveleave.global.error.exception.ErrorCode
import com.example.leaveleave.global.error.exception.LeaveLeaveException

object IncorrectPasswordException : LeaveLeaveException(ErrorCode.INCORRECT_PASSWORD)