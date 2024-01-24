package com.example.leaveleave.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class SignUpRequest(
    @field:NotBlank(message = "null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Size(min = 11, max = 20, message = "11자 ~ 12자까지 입력 가능합니다.")
    val phoneNumber: String,

    @field:NotBlank(message = "null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Size(min = 1, max = 5, message = "1자 ~ 5자까지 입력 가능합니다.")
    val name: String,

    @field:NotBlank(message = "null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Size(min = 8, max = 15 , message = "8자 ~ 15자까지 입력 가능합니다.")
    val accountId: String,

    @field:NotBlank
    @field:Pattern(
        regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;" +
                "<=>?@＼^_`{|}~]{8,30}$",
        message = "소문자, 숫자, 특수문자가 포함되어야 하며 8자~20자 사이여야 합니다."
    )
    val password: String,

//    @field:NotBlank
//    @field:Pattern(
//        regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;" +
//                "<=>?@＼^_`{|}~]{8,30}$",
//        message = "소문자, 숫자, 특수문자가 포함되어야 하며 8자~20자 사이여야 합니다."
//    )
//    val checkPassword: String,
)