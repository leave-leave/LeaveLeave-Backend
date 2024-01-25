package com.example.leaveleave.domain.feed.domain.repository

import com.example.leaveleave.domain.feed.domain.Feed
import org.springframework.data.jpa.repository.JpaRepository

interface FeedRepository : JpaRepository<Feed, Long> {
}