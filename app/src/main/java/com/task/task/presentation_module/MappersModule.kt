package com.task.task.presentation_module

import com.task.task.presentation_module.posts.mappers.PostsUiMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Mohammed Sayed Taguldeen on 30,November,2019
 * Cairo, Egypt.
 */

@Module
class MappersModule{

    @Provides
    @Singleton
    fun providePostsMapper(): PostsUiMapper =
        PostsUiMapper
}