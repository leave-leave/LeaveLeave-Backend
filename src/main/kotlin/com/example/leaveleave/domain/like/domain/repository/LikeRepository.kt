package com.example.leaveleave.domain.like.domain.repository

import com.example.leaveleave.domain.feed.domain.Feed
import com.example.leaveleave.domain.like.domain.Like
import com.example.leaveleave.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface LikeRepository : JpaRepository<Like, Long> {
    fun getByFeedAndUser(feed: Feed, user: User): Like
    fun existsByFeedAndUser(feed: Feed, user: User): Boolean
    fun findAllByUser(user: User): List<Like>
}