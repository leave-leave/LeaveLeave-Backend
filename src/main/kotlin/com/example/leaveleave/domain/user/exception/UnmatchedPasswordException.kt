package com.example.leaveleave.domain.user.exception

import com.example.leaveleave.global.error.exception.ErrorCode
import com.example.leaveleave.global.error.exception.LeaveLeaveException

object UnmatchedPasswordException : LeaveLeaveException(ErrorCode.UNMATCHED_PASSWORD)