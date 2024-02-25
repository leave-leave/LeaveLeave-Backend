package com.example.leaveleave.domain.user.presentation

import com.example.leaveleave.domain.user.facade.UserFacade
import com.example.leaveleave.domain.user.presentation.dto.request.SignInRequest
import com.example.leaveleave.domain.user.presentation.dto.request.SignUpRequest
import com.example.leaveleave.domain.user.presentation.dto.response.TokenResponse
import com.example.leaveleave.domain.user.presentation.dto.response.UserInfoResponse
import com.example.leaveleave.domain.user.service.SignInService
import com.example.leaveleave.domain.user.service.SignUpService
import com.example.leaveleave.domain.user.service.UserInfoService
import com.example.leaveleave.global.security.jwt.TokenProvider
import jdk.jshell.execution.Util
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/users")
@RestController
class UserController(
    private val signUpService: SignUpService,
    private val signInService: SignInService,
    private val userInfoService: UserInfoService,
    private val tokenProvider: TokenProvider,
    private val userFacade: UserFacade
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun signup(@RequestBody @Valid request: SignUpRequest) {
        signUpService.execute(request)
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    fun login(@RequestBody @Valid request: SignInRequest): TokenResponse {
        return signInService.execute(request)
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("token")
    fun refreshToken(@RequestHeader("Authorization") authorization: String): ResponseEntity<Any>{
        val token = authorization.removePrefix("Bearer").trim()

        return if (tokenProvider.validateToken(token)){
            val newToken = tokenProvider.generateToken(token)
            ResponseEntity.ok().body(mapOf("token" to newToken))
        } else{
            ResponseEntity.badRequest().body("Invalid token")
        }


    }
    @GetMapping("/{account-id}")
    fun checkUser(@PathVariable("account-id") accountId: String): ResponseEntity<String>{
        if (userFacade.checkAccountIdExist(accountId)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 존재하는 $accountId 입니다")
        } else{
            return ResponseEntity.ok("사용 가능한 $accountId 입니다")
        }
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user")
    fun getUserInfo(): UserInfoResponse {
        return userInfoService.execute()
    }
}