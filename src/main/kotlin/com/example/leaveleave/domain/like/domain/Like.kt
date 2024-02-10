package com.example.leaveleave.domain.like.domain

import com.example.leaveleave.domain.feed.domain.Feed
import com.example.leaveleave.domain.user.domain.User
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity(name = "tbl_like")
class Like(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    val likeId: Long? = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", columnDefinition = "VARCHAR(15)", nullable = false)
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", columnDefinition = "BIGINT", nullable = false)
    val feed: Feed
)