package com.example.leaveleave.domain.like.presentation

import com.example.leaveleave.domain.like.service.LikeService
import org.apache.tomcat.util.net.openssl.ciphers.Authentication
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/likes")
class LikeController(
    private val likeService: LikeService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}")
    fun createLike(@PathVariable("feed-id") feedId: Long){
        likeService.createLike(feedId)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    fun cancelLike(@PathVariable("feed-id") feedId: Long){
        likeService.cancelLike(feedId)
    }
}