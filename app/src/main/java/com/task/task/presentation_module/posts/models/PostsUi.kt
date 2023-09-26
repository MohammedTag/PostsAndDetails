package com.task.task.presentation_module.posts.models

import java.io.Serializable

data class PostsUi(
    val body: String,
    val id: Int,
    val title: String,
    val user: UserUi
):Serializable
