package com.example.leaveleave.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

class UpdatePasswordRequest(
    @field:NotBlank
    @field:Pattern(
        regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;" +
                "<=>?@＼^_`{|}~]{8,30}$",
        message = "소문자, 숫자, 특수문자가 포함되어야 하며 8자~20자 사이여야 합니다."
    )
    val password: String,
)