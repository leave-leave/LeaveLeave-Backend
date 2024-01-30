package com.example.leaveleave.domain.feed.service

import com.example.leaveleave.domain.feed.domain.Feed
import com.example.leaveleave.domain.feed.domain.repository.FeedRepository
import com.example.leaveleave.domain.feed.presentation.dto.request.CreateFeedRequest
import com.example.leaveleave.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateFeedService(
    private val feedRepository: FeedRepository,
    private val userFacade: UserFacade,
){
    @Transactional
    fun execute(request: CreateFeedRequest){
        val user = userFacade.getCurrentUser()
        val feed = feedRepository.save(
            Feed(
                null,
                user,
                request.title,
                request.content,

            )
        )
    }
}
