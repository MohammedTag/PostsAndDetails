package com.task.domain.domain_module.posts.models

data class PostsDomain(
    val body: String,
    val id: Int,
    val title: String,
    val user: Int
)