package com.example.leaveleave.domain.user.presentation.dto.request

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class UpdateModifyRequest(
    @field: NotNull(message = "null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field: Size(min = 1, max = 5, message = "1자 ~ 5자")
    val name: String,

    @field: NotNull(message = "null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field: Size(min = 11, max = 12, message = "11자 ~ 12자")
    val phoneNumber: String
)