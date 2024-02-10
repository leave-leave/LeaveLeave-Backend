package com.example.leaveleave.domain.feed.facade

import com.example.leaveleave.domain.feed.domain.Feed
import com.example.leaveleave.domain.feed.domain.repository.FeedRepository
import com.example.leaveleave.domain.feed.exception.FeedNotFoundException
import com.example.leaveleave.domain.feed.presentation.dto.response.LikeFeedListResponse
import com.example.leaveleave.domain.user.domain.User
import org.springframework.stereotype.Component

@Component
class FeedFacade(
    private val feedRepository: FeedRepository,
) {
    fun getByFeedId(feedID: Long): Feed{
        return feedRepository.findById(feedID).orElseThrow{FeedNotFoundException}
    }
    fun getFeedList(feeds: List<Feed>, user: User): List<LikeFeedListResponse>{
        return feeds.map{feed ->
            LikeFeedListResponse(feed.feedId, feed.title, feed.content)

        }
    }
}