package com.example.leaveleave.domain.user.presentation.dto.response

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
)