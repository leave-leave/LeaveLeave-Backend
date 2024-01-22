package com.example.leaveleave.global.exception

import com.example.leaveleave.global.error.exception.ErrorCode
import com.example.leaveleave.global.error.exception.LeaveLeaveException

object InternalServerError : LeaveLeaveException(ErrorCode.INTERNAL_SERVER_ERROR)