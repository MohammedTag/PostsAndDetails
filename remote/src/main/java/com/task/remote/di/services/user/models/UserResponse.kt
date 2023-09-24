package com.task.remote.di.services.user.models

import com.task.domain.domain_module.user.models.UserDomain

data class UserResponse(
    val email: String,
    val gender: String,
    val id: Int,
    val name: String,
    val status: String
){
    fun toDomain()= UserDomain(
        email = email,
        gender = gender,
        id = id,
        name = name,
        status = status
    )
}