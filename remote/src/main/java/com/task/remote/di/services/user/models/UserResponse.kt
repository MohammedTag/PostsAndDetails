package com.task.remote.di.services.user.models

data class UserResponse(
    val email: String,
    val gender: String,
    val id: Int,
    val name: String,
    val status: String
)