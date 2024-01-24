package com.example.leaveleave.domain.user.presentation

import com.example.leaveleave.domain.user.presentation.dto.request.SignInRequest
import com.example.leaveleave.domain.user.presentation.dto.request.SignUpRequest
import com.example.leaveleave.domain.user.presentation.dto.response.TokenResponse
import com.example.leaveleave.domain.user.presentation.dto.response.UserInfoResponse
import com.example.leaveleave.domain.user.service.SignInService
import com.example.leaveleave.domain.user.service.SignUpService
import com.example.leaveleave.domain.user.service.UserInfoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/users")
@RestController
class UserController(
    private val signUpService: SignUpService,
    private val signInService: SignInService,
    private val userInfoService: UserInfoService,
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun signup(@RequestBody @Valid request: SignUpRequest){
        signUpService.execute(request)
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    fun login(@RequestBody @Valid request: SignInRequest): TokenResponse{
        return signInService.execute(request)
    }

    @GetMapping
    fun getUserInfo(): UserInfoResponse{
        return userInfoService.execute()
    }
}