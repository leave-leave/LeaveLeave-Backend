package com.example.leaveleave.domain.feed.domain

import com.example.leaveleave.global.entity.BaseUUIDEntity
import com.example.leaveleave.domain.user.domain.User
import javax.persistence.*

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

) : BaseUUIDEntity() {
    fun updateFeed(title: String,content: String){
        this.title = title
        this.content = content
    }
}