package com.task.remote.di.services.posts.models

data class PostsResponse(
    val body: String,
    val id: Int,
    val title: String,
    val user_id: Int
)