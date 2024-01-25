package com.example.leaveleave.domain.feed.presentation

import com.example.leaveleave.domain.feed.presentation.dto.request.CreateFeedRequest
import com.example.leaveleave.domain.feed.presentation.dto.request.UpdateFeedRequest
import com.example.leaveleave.domain.feed.service.CreateFeedService
import com.example.leaveleave.domain.feed.service.DeleteFeedService
import com.example.leaveleave.domain.feed.service.UpdateFeedService
import org.hibernate.hql.internal.ast.tree.InLogicOperatorNode
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import javax.validation.Valid


@RequestMapping("/feeds")
@RestController
class FeedController(
    private val createFeedService: CreateFeedService,
    private val updateFeedService: UpdateFeedService,
    private val deleteFeedService: DeleteFeedService,
) {
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping
    fun createFeed(@RequestBody @Valid request: CreateFeedRequest){
        createFeedService.execute(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{feed-id}")
    fun updateFeed(@PathVariable("feed-id") feedId: Long, @RequestBody @Valid request: UpdateFeedRequest){
        updateFeedService.execute(feedId,request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    fun deleteFeed(@PathVariable("feed-id") feedId: Long){
        deleteFeedService.execute(feedId)
    }

}