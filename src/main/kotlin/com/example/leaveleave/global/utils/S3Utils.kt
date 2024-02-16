package com.example.leaveleave.global.utils

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.example.leaveleave.global.utils.exception.BadFileExtensionException
import org.springframework.beans.factory.annotation.Value
import org.apache.commons.io.IOUtils
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.io.ByteArrayInputStream

@Component
class S3Utils(
    private val s3Client: AmazonS3Client,
    @Value("\${cloud.aws.s3.bucket}")
    private val bucketName: String,
) {
    fun upload(file: MultipartFile): String {
        val ext = verificationFile(file)
        val fileName = generateRandomString(5) + "." + ext
        val objMeta = ObjectMetadata()
        val bytes = IOUtils.toByteArray(file.inputStream)
        val byteArrayIs = ByteArrayInputStream(bytes)
        objMeta.contentLength = bytes.size.toLong()
        s3Client.putObject(
            PutObjectRequest(bucketName, fileName, byteArrayIs, objMeta).withCannedAcl(
                CannedAccessControlList.PublicRead
            )
        )
        return s3Client.getResourceUrl(bucketName,fileName)

    }

    private fun verificationFile(file: MultipartFile): String {
        val originalFilename = file.originalFilename
        val ext = originalFilename!!.substring(originalFilename.lastIndexOf(".") + 1)
        if (!(ext == "jpg" || ext == "jpeg" || ext == "png" || ext == "heic")) {
            throw BadFileExtensionException
        }
        return ext
    }
}


fun generateRandomString(length: Int): String {
    val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')

    return (1..length)
        .map { allowedChars.random() }
        .joinToString()
}