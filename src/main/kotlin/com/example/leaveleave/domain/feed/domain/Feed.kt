package com.example.leaveleave.domain.feed.domain

import com.example.leaveleave.domain.comment.domain.Comment
import com.example.leaveleave.domain.like.domain.Like
import com.example.leaveleave.domain.user.domain.User
import java.time.LocalDateTime
import java.util.Optional
import javax.persistence.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "tbl_feed")
class Feed(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feed_id", columnDefinition = "BIGINT", nullable = false)
    val feedId: Long?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id",  nullable = false)
    val user: User,

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    var title: String,

    @Column(columnDefinition = "VARCHAR(500)", nullable = false)
    var content: String,

    val createdAt: LocalDateTime,

    // TODO: orphanRemoval = true <- 이거 선빠이한테 질문하기
    @OneToMany(mappedBy = "feed", cascade = [CascadeType.ALL], orphanRemoval = true)
    val comment: MutableList<Comment> = mutableListOf(),
){
    fun updateFeed(title: String,content: String){
        this.title = title
        this.content = content
    }
}