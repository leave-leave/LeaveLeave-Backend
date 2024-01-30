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
    fun createLike(feedId: Long){
        val user = userFacade.getCurrentUser()
        val feed = feedRepository.findById(feedId).orElseThrow {FeedNotFoundException}

        val existingLike = likeRepository.findByFeedIdAndUserId(feedId,user.accountId)
        if(existingLike == null){
            likeRepository.save(Like(userId = user.accountId, feedId = feedId))
        } else {
            throw AlreadyExistsLikeException
        }
    }

    fun cancelLike(feedId: Long){
        val user = userFacade.getCurrentUser()
        val feed = feedRepository.findById(feedId).orElseThrow {FeedNotFoundException}

        val existingLike = likeRepository.findByFeedIdAndUserId(feedId, user.accountId)
        if(existingLike != null){
            likeRepository.delete(existingLike)
        } else {
            throw AlreadyExistsLikeException
        }
    }
}