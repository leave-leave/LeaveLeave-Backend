package com.example.leaveleave.domain.like.service

import com.example.leaveleave.domain.feed.domain.repository.FeedRepository
import com.example.leaveleave.domain.feed.exception.FeedNotFoundException
import com.example.leaveleave.domain.like.domain.Like
import com.example.leaveleave.domain.like.domain.repository.LikeRepository
import com.example.leaveleave.domain.like.exception.AlreadyExistsLikeException
import com.example.leaveleave.domain.user.domain.User
import com.example.leaveleave.domain.user.domain.repository.UserRepository
import com.example.leaveleave.domain.user.exception.UserNotFoundException
import com.example.leaveleave.domain.user.facade.UserFacade
import com.example.leaveleave.global.security.SecurityConfig
import org.apache.catalina.security.SecurityUtil
import org.apache.tomcat.util.net.openssl.ciphers.Authentication
import org.springframework.stereotype.Service

@Service
class LikeService(
    private val likeRepository: LikeRepository,
    private val userRepository: UserRepository,
    private val feedRepository: FeedRepository,
) {
    fun createLike(feedId: Long, userId: String){
        val user = userRepository.findById(userId).orElseThrow {UserNotFoundException}
        val feed = feedRepository.findById(feedId).orElseThrow {FeedNotFoundException}

        val existingLike = likeRepository.findByFeedIdAndUserId(feedId, userId)
        if(existingLike == null){
            likeRepository.save(Like(userId = userId, feedId = feedId))
        } else {
            throw AlreadyExistsLikeException
        }
    }

    fun cancelLike(userId: String,feedId: Long){
        val user = userRepository.findById(userId).orElseThrow {UserNotFoundException}
        val feed = feedRepository.findById(feedId).orElseThrow {FeedNotFoundException}

        val existingLike = likeRepository.findByFeedIdAndUserId(feedId, userId)
        if(existingLike != null){
            likeRepository.delete(existingLike)
        } else {
            throw AlreadyExistsLikeException
        }
    }
}