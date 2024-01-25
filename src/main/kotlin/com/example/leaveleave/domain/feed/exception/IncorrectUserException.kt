package com.example.leaveleave.domain.feed.exception

import com.example.leaveleave.global.error.exception.ErrorCode
import com.example.leaveleave.global.error.exception.LeaveLeaveException

object IncorrectUserException : LeaveLeaveException(ErrorCode.INCORRECT_USER)