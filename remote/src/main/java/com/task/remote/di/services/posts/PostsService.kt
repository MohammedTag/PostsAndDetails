package com.task.remote.di.services.posts

import com.task.remote.di.EndPoints
import com.task.remote.di.services.posts.models.CommentResponse
import com.task.remote.di.services.posts.models.PostsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PostsService {

    @GET(EndPoints.posts)
    fun getPosts():Single<List<PostsResponse>>

    @GET(EndPoints.postDetails)
    fun getPostDetails(@Path("{postId}") postId:Int):Single<List<CommentResponse>>
}