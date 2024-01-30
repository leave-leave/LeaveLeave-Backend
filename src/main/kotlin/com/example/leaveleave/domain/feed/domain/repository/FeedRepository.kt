package com.example.leaveleave.domain.feed.domain.repository

import com.example.leaveleave.domain.feed.domain.Feed
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.domain.Pageable

interface FeedRepository : JpaRepository <Feed, Long> {
    fun findAllByTitleContainingOrderByCreatedAtAsc(title: String, pageable: Pageable): Page<Feed>
}