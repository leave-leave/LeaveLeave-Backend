package com.example.leaveleave.domain.feed.service

import com.example.leaveleave.domain.feed.domain.repository.FeedRepository
import com.example.leaveleave.domain.feed.facade.FeedFacade
import com.example.leaveleave.domain.feed.presentation.dto.response.PageFeedListResponse
import com.example.leaveleave.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.data.domain.Pageable

@Service
class SearchFeedService(
    private val userFacade: UserFacade,
    private val feedFacade: FeedFacade,
    private val feedRepository: FeedRepository,
) {
    @Transactional(readOnly = true)
    fun execute(keyword: String, pageable: Pageable): PageFeedListResponse{
        val user = userFacade.getCurrentUser()
        val feeds = feedRepository.findAllByTitleContainingOrderByCreatedAtAsc(keyword,pageable)
        return PageFeedListResponse(
            feeds.totalPages,
            feeds.totalPages.equals(pageable.pageNumber + 1),
            feedFacade.getFeedList(feeds.content, user)
        )
    }
}