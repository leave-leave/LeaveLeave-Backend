package com.example.leaveleave

import com.example.leaveleave.global.security.jwt.TokenProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableConfigurationProperties(TokenProperties::class)
@SpringBootApplication
class LeaveLeaveApplication

fun main(args: Array<String>) {
    runApplication<LeaveLeaveApplication>(*args)
}
