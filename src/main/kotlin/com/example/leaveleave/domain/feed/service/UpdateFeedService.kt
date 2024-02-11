package com.example.leaveleave.domain.feed.service

import com.example.leaveleave.domain.feed.exception.IncorrectUserException
import com.example.leaveleave.domain.feed.facade.FeedFacade
import com.example.leaveleave.domain.feed.presentation.dto.request.UpdateFeedRequest
import com.example.leaveleave.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
data class UpdateFeedService(
    private val feedFacade: FeedFacade,
    private val userFacade: UserFacade,
) {
    @Transactional
    fun execute(feedId: Long, request: UpdateFeedRequest) {
        val feed = feedFacade.getByFeedId(feedId)
        val user = userFacade.getCurrentUser()
        if (user != feed.user) {
            throw IncorrectUserException
        }
        feed.updateFeed(request.title, request.content)
    }
}
