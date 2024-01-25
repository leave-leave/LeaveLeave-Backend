package com.example.leaveleave.domain.feed.service

import com.example.leaveleave.domain.feed.domain.repository.FeedRepository
import com.example.leaveleave.domain.feed.exception.IncorrectUserException
import com.example.leaveleave.domain.feed.facade.FeedFacade
import com.example.leaveleave.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
data class DeleteFeedService(
    private val feedFacade: FeedFacade,
    private val userFacade: UserFacade,
    private val feedRepository: FeedRepository,
) {
    @Transactional
    fun execute(feedId: Long){
        val feed = feedFacade.getByFeedId(feedId)
        val user = userFacade.getCurrentUser()

        if(user != feed.user){
            throw IncorrectUserException
        }
        feedRepository.delete(feed)
    }
}