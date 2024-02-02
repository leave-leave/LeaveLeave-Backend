package com.example.leaveleave.domain.like.service

import com.example.leaveleave.domain.feed.domain.repository.FeedRepository
import com.example.leaveleave.domain.feed.exception.FeedNotFoundException
import com.example.leaveleave.domain.like.domain.Like
import com.example.leaveleave.domain.like.domain.repository.LikeRepository
import com.example.leaveleave.domain.like.exception.AlreadyExistsLikeException
import com.example.leaveleave.domain.user.domain.repository.UserRepository
import com.example.leaveleave.domain.user.exception.UserNotFoundException
import com.example.leaveleave.domain.user.facade.UserFacade
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication
import org.springframework.stereotype.Service

@Service
class LikeService(
    private val likeRepository: LikeRepository,
    private val feedRepository: FeedRepository,
    private val userFacade: UserFacade
) {
    fun createLike(feedId: Long) {
        val user = userFacade.getCurrentUser()
        val feed = feedRepository.findById(feedId).orElseThrow { FeedNotFoundException }

        val isExistLike = likeRepository.existsByFeedAndUser(feed, user)
        if (isExistLike) {
            throw AlreadyExistsLikeException
        }

        likeRepository.save(Like(user = user, feed = feed))
    }

    fun cancelLike(feedId: Long) {
        val user = userFacade.getCurrentUser()
        val feed = feedRepository.findById(feedId).orElseThrow { FeedNotFoundException }

        val like = likeRepository.getByFeedAndUser(feed, user)
        likeRepository.delete(like)
    }
}