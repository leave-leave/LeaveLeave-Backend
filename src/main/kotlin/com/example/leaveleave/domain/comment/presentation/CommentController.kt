package com.example.leaveleave.domain.comment.presentation

import com.example.leaveleave.domain.comment.domain.Comment
import com.example.leaveleave.domain.comment.presentation.dto.request.CommentRequest
import com.example.leaveleave.domain.comment.service.CommentService
import com.example.leaveleave.domain.user.domain.User
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RequestMapping("/comment")
@RestController
class CommentController(
    private val commentService: CommentService,
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add/{feed-id}")
    fun addComment(@PathVariable("feed-id") feedId: Long, @RequestBody @Valid body: CommentRequest){
        commentService.addComment(feedId, body.comment)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{comment-id}")
    fun deleteComment(@PathVariable("comment-id") commentId: Long){
        commentService.minusComment(commentId)
    }




}