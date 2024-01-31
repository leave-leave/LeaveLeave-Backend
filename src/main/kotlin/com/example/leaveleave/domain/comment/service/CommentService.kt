package com.example.leaveleave.domain.comment.service

import com.example.leaveleave.domain.comment.domain.Comment
import com.example.leaveleave.domain.comment.domain.repository.CommentRepository
import com.example.leaveleave.domain.feed.domain.repository.FeedRepository
import com.example.leaveleave.domain.user.domain.User
import com.example.leaveleave.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException
import javax.persistence.Id

@Service
class CommentService(
    private val commentRepository: CommentRepository,
    private val feedRepository: FeedRepository,
    private val userFacade: UserFacade
) {
    @Transactional
    fun addComment(feedId: Long, comment: String) {
        val user = userFacade.getCurrentUser()
        val feed = feedRepository.findById(feedId)
            .orElseThrow { IllegalArgumentException("해당 게시글이 없습니다. id=$feedId")}

        commentRepository.save(Comment(null,comment,feed,user))
    }

    @Transactional
    fun minusComment(commentId: Long) {
        commentRepository.deleteById(commentId)
    }
}