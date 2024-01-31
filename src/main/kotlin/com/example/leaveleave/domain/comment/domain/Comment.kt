package com.example.leaveleave.domain.comment.domain

import com.example.leaveleave.domain.feed.domain.Feed
import com.example.leaveleave.domain.user.domain.User
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne


@Entity(name = "tbl_comment")
data class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(columnDefinition = "TEXT" , nullable = false)
    val comment: String,

    @ManyToOne
    @JoinColumn(name = "feed_id")
    var feed: Feed? = null,

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User? = null
){
    fun save(feed: Feed, user: User){
        this.feed = feed
        this.user = user
    }
}