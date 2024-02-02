package com.example.leaveleave.domain.comment.domain

import com.example.leaveleave.domain.feed.domain.Feed
import com.example.leaveleave.domain.user.domain.User
import javax.persistence.*


@Entity(name = "tbl_comment")
data class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(columnDefinition = "TEXT" , nullable = false)
    val comment: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    var feed: Feed? = null,

    @ManyToOne
    @JoinColumn(name = "account_id")
    var user: User? = null
){
    fun save(feed: Feed, user: User){
        this.feed = feed
        this.user = user
    }
}