package com.example.leaveleave.domain.like.exception

import com.example.leaveleave.global.error.exception.ErrorCode.ALREADY_EXIST_LIKE
import com.example.leaveleave.global.error.exception.LeaveLeaveException

object AlreadyExistsLikeException : LeaveLeaveException(ALREADY_EXIST_LIKE)