package com.example.leaveleave.domain.feed.presentation.dto.response

data class PageFeedListResponse (
    val totalPage: Int,
    val isFinalPage: Boolean,
    val feeds: List<FeedElement>
)