package com.task.remote.di.services.user

import com.task.remote.di.EndPoints
import com.task.remote.di.services.user.models.UserResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Mohammed Taguldeen on 24/09/2023.
 */
interface UsersService {

    @GET(EndPoints.userDetails)
    fun getUser(@Path("userId") userId: Int): Single<UserResponse>
}