package com.task.domain.domain_module.posts.models

data class CommentDomain(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val post_id: Int
)