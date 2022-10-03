package com.thinandlong.hatesugar.common.dto

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

data class ResponseDto<T>(val data: T)

fun <T> T.ok() = ResponseEntity.ok(this)

fun <T> T.created() = ResponseEntity.status(HttpStatus.CREATED).body(this)

fun void(): ResponseEntity.HeadersBuilder<*> = ResponseEntity.noContent()
