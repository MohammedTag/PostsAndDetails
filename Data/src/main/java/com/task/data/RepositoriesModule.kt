package com.task.data

import com.task.data.sortedGitRepositories.PostsDatasource
import com.task.domain.domain_module.posts.repository.PostsRepository
import com.task.remote.di.retrofit.service.ServicesModule
import com.task.remote.di.services.posts.PostsService
import com.task.remote.di.services.user.UsersService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(
    includes = [
        ServicesModule::class
    ]
)
class RepositoriesModule {

    @Provides
    @Singleton
    fun providesSortedGitReposRepository(
        postsService: PostsService,
        usersService: UsersService
    ): PostsRepository =
        PostsDatasource(
            postsService,
            usersService
        )
}