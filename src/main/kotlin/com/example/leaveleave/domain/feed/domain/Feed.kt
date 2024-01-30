package com.example.leaveleave.domain.feed.domain

import com.example.leaveleave.domain.user.domain.User
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "tbl_feed")
class Feed(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT", nullable = false)
    val feedId: Long?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id",  nullable = false)
    val user: User,

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    var title: String,

    @Column(columnDefinition = "VARCHAR(500)", nullable = false)
    var content: String,

    @CreatedDate
    @Column(columnDefinition = "DATETIME", nullable = false)
    val createdAt: LocalDateTime,

    var like: Int = 0

){
    fun updateFeed(title: String,content: String){
        this.title = title
        this.content = content
    }

    fun like(){
        this.like += 1
    }
}