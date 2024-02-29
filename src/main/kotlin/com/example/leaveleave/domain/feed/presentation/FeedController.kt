package com.example.leaveleave.domain.feed.presentation

import com.example.leaveleave.domain.feed.domain.Feed
import com.example.leaveleave.domain.feed.domain.repository.FeedRepository
import com.example.leaveleave.domain.feed.presentation.dto.request.CreateFeedRequest
import com.example.leaveleave.domain.feed.presentation.dto.request.UpdateFeedRequest
import com.example.leaveleave.domain.feed.presentation.dto.response.FeedListResponse
import com.example.leaveleave.domain.feed.presentation.dto.response.LikeFeedListResponse
import com.example.leaveleave.domain.feed.service.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import org.springframework.http.ResponseEntity


@RequestMapping("/feeds")
@RestController
class FeedController(
    private val createFeedService: CreateFeedService,
    private val updateFeedService: UpdateFeedService,
    private val getFeedService: GetFeedService,
    private val feedRepository: FeedRepository,
    private val getLikeFeedListService: GetLikeFeedListService,
    private val  getFeedListService: GetFeedListService
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createFeed(@RequestBody @Valid request: CreateFeedRequest) {
        createFeedService.execute(request)
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{feed-id}")
    fun updateFeed(@PathVariable("feed-id") feedId: Long, @RequestBody @Valid request: UpdateFeedRequest) {
        updateFeedService.execute(feedId, request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    fun deleteFeed(@PathVariable("feed-id") feedId: Long) {
        feedRepository.deleteById(feedId)
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{feed-id}")
    fun getFeed(@PathVariable("feed-id") feedId: Long): ResponseEntity<Feed> {
        val feed = getFeedService.getFeedWithComment(feedId)
        return ResponseEntity.ok(feed)
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/like")
    fun getLikeFeedList(): List<LikeFeedListResponse> {
        val likes = getLikeFeedListService.execute()
        return likes.map { like ->
            LikeFeedListResponse(
                id = like.feed.feedId!!,
                title = like.feed.title,
                content = like.feed.content
            )
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    fun getFeedList(): List<FeedListResponse> {
        return getFeedListService.execute()
    }
}