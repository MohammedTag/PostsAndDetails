package com.task.task.presentation_module.posts.models

data class CommentsUi(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val post_id: Int,
)
