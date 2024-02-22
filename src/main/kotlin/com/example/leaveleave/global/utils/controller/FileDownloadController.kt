package com.example.leaveleave.global.utils.controller

import com.amazonaws.services.s3.AmazonS3
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.UrlResource
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class FileDownloadController {
    @Autowired
    private lateinit var amazonS3: AmazonS3

    @GetMapping("/downloadImage")
    fun downloadImage(@RequestParam originalFilename: String): ResponseEntity<UrlResource> {
        val bucket = "leaveleave"

        val urlResource = UrlResource(amazonS3.getUrl(bucket, originalFilename).toURI())

        val contentDisposition = "attachment; filename=\"$originalFilename\""

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
            .body(urlResource)
    }
}