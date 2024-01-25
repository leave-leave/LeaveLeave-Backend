package com.example.leaveleave.domain.feed.presentation.dto.response

import java.util.UUID

data class FeedElement (
    val id: UUID,
    val title: String,
    val content: String,
)