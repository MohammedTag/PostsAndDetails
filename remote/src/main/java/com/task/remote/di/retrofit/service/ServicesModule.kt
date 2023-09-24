package com.task.remote.di.retrofit.service

import com.task.remote.di.retrofit.RetrofitModule
import com.task.remote.di.services.posts.PostsService
import com.task.remote.di.services.user.UsersService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module(includes = [RetrofitModule::class])

class ServicesModule {

    @Provides
    @Singleton
    fun providePostsService(
        retrofit: Retrofit
    ): PostsService {
        return retrofit.create(PostsService::class.java)
    }
    @Provides
    @Singleton
    fun provideUserDetailsService(
        retrofit: Retrofit
    ): UsersService {
        return retrofit.create(UsersService::class.java)
    }
}