package com.example.leaveleave.domain.feed.presentation.dto.response


data class FeedDetailsResponse(
    val id: Long,
    val title: String,
    val content: String,
    val username: String,
    val comment: String
)