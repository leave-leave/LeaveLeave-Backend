package com.example.leaveleave.domain.feed.service

import com.example.leaveleave.domain.feed.domain.repository.FeedRepository
import com.example.leaveleave.domain.feed.presentation.dto.response.FeedListResponse
import com.example.leaveleave.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class GetFeedListService(
    private val feedRepository: FeedRepository,
    private val userFacade: UserFacade
) {
    fun execute(): List<FeedListResponse>{
        val user = userFacade.getCurrentUser()
        val feedList = feedRepository.findAll()

        return FeedListResponse.format(feedList, user.accountId)
    }
}