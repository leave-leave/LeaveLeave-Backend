package com.example.leaveleave.domain.feed.presentation.dto.response

import com.example.leaveleave.domain.comment.domain.Comment
import com.example.leaveleave.domain.feed.domain.Feed
import com.example.leaveleave.domain.user.domain.User

data class FeedListUserResponse(
    val name: String
) {
    companion object {
        fun format(user: User): FeedListUserResponse {
            return FeedListUserResponse(
                name = user.name
            )
        }
    }
}


data class FeedListCommentResponse(
    val user: FeedListUserResponse,
    val comment: String
){
    companion object{
        fun format(comment: Comment): FeedListCommentResponse{
            return FeedListCommentResponse(
                user = FeedListUserResponse.format(comment.user),
                comment = comment.comment
            )
        }
    }
}

data class FeedListResponse(
    val id: Long,
    val title: String,
    val content: String,
    val user: FeedListUserResponse,
//    val imageUrl: String,
    val userLike: Boolean,
    val likeCount: Int,
    val commentCount: Int,
    val commentList: List<FeedListCommentResponse>
) {
    companion object {
        fun format(feedList: List<Feed>, accountId: String): List<FeedListResponse> {
            return feedList.map { feed ->
                FeedListResponse(
                    id = feed.feedId!!,
                    title = feed.title,
                    content = feed.content,
                    user = FeedListUserResponse.format(feed.user),
                    userLike = feed.likeList.find { like -> like.user.accountId.equals(accountId) } === null,
                    likeCount = feed.likeList.count(),
                    commentCount = feed.commentList.count(),
                    commentList = feed.commentList.map { comment -> FeedListCommentResponse.format(comment) }
                )
            }
        }
    }
}
