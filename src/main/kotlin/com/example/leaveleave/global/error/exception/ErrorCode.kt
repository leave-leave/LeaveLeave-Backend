package com.example.leaveleave.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String,
) {
    UNMATCHED_PASSWORD(400, "Unmatched Password"),
    INCORRECT_PASSWORD(400, "Incorrect Password"),
    INCORRECT_USER(400, "Incorrect User"),
    NOT_ALLOW_SELF_APPLICATION(400, "Not Allow Self Application"),
    BAD_FILE_EXTENSION(400, "Bad File Extension"),

    TOKEN_INVALID(401, "Token Invalid"),
    TOKEN_EXPIRED(401, "Token Expired"),

    USER_NOT_FOUND(404, "User Not Found"),
    FEED_NOT_FOUND(404, "Feed Not Found"),

    ALREADY_ACCOUNT_ID(409, "Already Account Id"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");
}