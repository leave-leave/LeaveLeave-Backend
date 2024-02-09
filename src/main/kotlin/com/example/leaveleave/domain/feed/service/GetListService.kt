package com.example.leaveleave.domain.feed.service

import com.example.leaveleave.domain.like.domain.repository.LikeRepository
import com.example.leaveleave.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class GetListService(
    private val userFacade: UserFacade,
    private val likeRepository: LikeRepository
) {
    fun execute(){
        val user = userFacade.getCurrentUser()
        val likeList = likeRepository.findAllByUser(user)

        println(likeList[0].feed)
    }
}