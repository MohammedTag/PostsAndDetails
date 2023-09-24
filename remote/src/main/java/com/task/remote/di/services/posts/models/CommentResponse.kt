package com.task.remote.di.services.posts.models

import com.task.domain.domain_module.posts.models.CommentDomain

data class CommentResponse(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val post_id: Int,
) {
    fun toDomain() = CommentDomain(
        body = body,
        email = email,
        id = id,
        name = name,
        post_id = post_id
    )
}