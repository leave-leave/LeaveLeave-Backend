package com.example.leaveleave.domain.feed.service

import com.example.leaveleave.domain.comment.domain.repository.CommentRepository
import com.example.leaveleave.domain.feed.domain.Feed
import com.example.leaveleave.domain.feed.domain.repository.FeedRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityNotFoundException

@Service
data class GetFeedService(
    private val commentRepository: CommentRepository,
    private val feedRepository: FeedRepository,
) {
    @Transactional
    fun getFeedWithComment(feedId: Long): Feed{
        val feed = feedRepository.findById(feedId)
            .orElseThrow{(EntityNotFoundException("Feed not found with id : $feedId"))}

        val comments = commentRepository.findById(feedId)

        return feed
    }
}