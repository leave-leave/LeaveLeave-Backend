package com.example.leaveleave.domain.like.domain

import javax.persistence.*

@Entity(name = "tbl_like")
class Like(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    val likeId: Long? = null,

    @Column(name = "feed_id")
    val feedId: Long,

    @Column(name = "user_id")
    val userId: Long,

    val cancellable: Boolean = false
)