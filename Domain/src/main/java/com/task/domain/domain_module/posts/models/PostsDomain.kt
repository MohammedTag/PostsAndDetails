package com.task.domain.domain_module.posts.models

import com.task.domain.domain_module.user.models.UserDomain

data class PostsDomain(
    val body: String,
    val id: Int,
    val title: String,
    val user: UserDomain
)