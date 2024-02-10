package com.example.leaveleave.domain.feed.service

import com.example.leaveleave.domain.like.domain.Like
import com.example.leaveleave.domain.like.domain.repository.LikeRepository
import com.example.leaveleave.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
data class GetLikeFeedListService(
    private val userFacade: UserFacade,
    private val likeRepository: LikeRepository
) {
    fun execute(): List<Like> {
        val user = userFacade.getCurrentUser()
        return likeRepository.findAllByUser(user)
    }
}
