package com.task.remote.di.services.user

import com.task.remote.di.EndPoints
import com.task.remote.di.services.posts.models.PostsResponse
import com.task.remote.di.services.user.models.UserResponse
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Mohammed Taguldeen on 24/09/2023.
 */
interface UsersService {

    @GET(EndPoints.userDetails)
    fun getPosts(): Single<UserResponse>
}