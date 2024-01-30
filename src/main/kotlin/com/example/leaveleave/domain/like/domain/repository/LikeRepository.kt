package com.example.leaveleave.domain.like.domain.repository

import com.example.leaveleave.domain.like.domain.Like
import com.example.leaveleave.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.function.LongFunction

interface LikeRepository : JpaRepository <Like, Long> {
    fun findByFeedIdAndUserId(feedId : Long, userId : String): Like?
    fun countByFeedId(feedId: Long): Long

    fun deleteByFeedIdAndAndLikeId(userId: String, like: Like)
}