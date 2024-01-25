package com.example.leaveleave.domain.feed.exception

import com.example.leaveleave.global.error.exception.ErrorCode
import com.example.leaveleave.global.error.exception.LeaveLeaveException

object FeedNotFoundException : LeaveLeaveException(ErrorCode.FEED_NOT_FOUND)