package com.example.leaveleave.domain.feed.exception

import com.example.leaveleave.global.error.exception.ErrorCode
import com.example.leaveleave.global.error.exception.LeaveLeaveException

object NotAllowSelfApplicationException : LeaveLeaveException(ErrorCode.NOT_ALLOW_SELF_APPLICATION)