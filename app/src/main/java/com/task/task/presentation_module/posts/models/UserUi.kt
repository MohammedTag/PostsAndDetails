package com.task.task.presentation_module.posts.models

import java.io.Serializable

data class UserUi(
    val email: String,
    val gender: String,
    val id: Int,
    val name: String,
    val status: String,
) : Serializable
