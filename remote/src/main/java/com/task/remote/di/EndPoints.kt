package com.task.remote.di

object EndPoints {
    const val version = "v2"
    const val posts = "${version}/posts"
    const val userDetails = "${version}/users/{userId}"
    const val postDetails = "${version}/posts/{postId}/comments"
}