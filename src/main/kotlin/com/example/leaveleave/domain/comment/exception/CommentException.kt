package com.example.leaveleave.domain.comment.exception

import com.example.leaveleave.global.exception.BaseException
import com.example.leaveleave.global.exception.BaseExceptionType

class CommentException(
    private val baseExceptionType : BaseExceptionType
) : BaseException(){
    override fun getExceptionType(): BaseExceptionType {
        return baseExceptionType
    }
}