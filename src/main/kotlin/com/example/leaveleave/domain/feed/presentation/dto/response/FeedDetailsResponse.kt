package com.example.leaveleave.domain.feed.presentation.dto.response

import java.util.UUID

data class FeedDetailsResponse (
    val id: UUID,
    val title: String,
    val content: String,
    val username: String,
)