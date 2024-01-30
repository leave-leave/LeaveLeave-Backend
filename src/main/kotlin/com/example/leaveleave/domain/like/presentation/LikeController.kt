package com.example.leaveleave.domain.like.presentation

import com.example.leaveleave.domain.like.service.LikeService
import org.apache.tomcat.util.net.openssl.ciphers.Authentication
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/likes")
class LikeController(
    private val likeService: LikeService,
) {

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/create")
    fun createLike(authentication: Authentication, @RequestParam feedId: Long){
        likeService.createLike(authentication ,feedId)
    }

}