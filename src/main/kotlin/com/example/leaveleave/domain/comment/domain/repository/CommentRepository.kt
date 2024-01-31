package com.example.leaveleave.domain.comment.domain.repository

import com.example.leaveleave.domain.comment.domain.Comment
import io.lettuce.core.GeoArgs.Sort
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface CommentRepository : JpaRepository<Comment, Long> {
}