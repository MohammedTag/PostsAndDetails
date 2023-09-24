package com.task.remote.di.services.posts.models

import com.task.domain.domain_module.posts.models.PostsDomain

data class PostsResponse(
    val body: String,
    val id: Int,
    val title: String,
    val user_id: Int,
) {
    fun toDomain() = PostsDomain(body = body, id = id, title = title, user = user_id)
}