package com.task.task.presentation_module.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.task.task.di.ViewModelFactory
import com.task.task.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Mohammed Taguldeen on 13/07/2023.
 */
@Module
abstract class PostsViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel::class)
    internal abstract fun bindPostsViewModel(postsViewModel: PostsViewModel): ViewModel

}