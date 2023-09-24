package com.task.remote.di.utils

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ResponseListWrapper<T>(val data: List<T>)

@JsonClass(generateAdapter = true)
class ResponseWrapper<T>(val data: T)