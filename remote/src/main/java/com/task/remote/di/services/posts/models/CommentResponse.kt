package com.task.remote.di.services.posts.models

data class CommentResponse(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val post_id: Int
)