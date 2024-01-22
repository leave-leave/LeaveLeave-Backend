package com.example.leaveleave.domain.user.exception

import com.example.leaveleave.global.error.exception.ErrorCode
import com.example.leaveleave.global.error.exception.LeaveLeaveException

object AlreadyAccountIdException : LeaveLeaveException(ErrorCode.ALREADY_ACCOUNT_ID)