package com.example.leaveleave.global.exception

import com.example.leaveleave.global.error.exception.ErrorCode
import com.example.leaveleave.global.error.exception.LeaveLeaveException

object TokenInvalidException : LeaveLeaveException(ErrorCode.TOKEN_INVALID)