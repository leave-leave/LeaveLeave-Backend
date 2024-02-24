package com.example.leaveleave.global.utils.controller

import com.amazonaws.services.s3.AmazonS3
import com.example.leaveleave.global.utils.dto.FileUploadResponse
import com.example.leaveleave.global.utils.service.S3UploadService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RequestMapping("/file")
@RestController
class FileController(
    private val s3UploadService: S3UploadService
) {
    @PostMapping("/upload")
    fun saveFile(@RequestParam("file") multiPartFile: MultipartFile): FileUploadResponse {
        val fileUrl = s3UploadService.saveFile(multiPartFile)
        return FileUploadResponse(fileUrl)
    }
}