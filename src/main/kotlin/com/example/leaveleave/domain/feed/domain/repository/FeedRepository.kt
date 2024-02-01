package com.example.leaveleave.domain.feed.domain.repository

import com.example.leaveleave.domain.feed.domain.Feed
import com.example.leaveleave.domain.user.domain.User
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.Optional

interface FeedRepository : JpaRepository <Feed, Long> {
    fun findAllByTitleContainingOrderByCreatedAtAsc(title: String, pageable: Pageable): Page<Feed>
}