package com.task.task.presentation_module.comments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.task.task.di.ViewModelFactory
import com.task.task.di.ViewModelKey
import com.task.task.presentation_module.posts.PostsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CommentsViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CommentsViewModel::class)
    internal abstract fun bindCommentsViewModel(commentsViewModel: CommentsViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}