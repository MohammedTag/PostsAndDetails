package com.task.task.di.fragment

import com.task.task.di.scope.FragmentScope
import com.task.task.ui_module.postDetails.PostDetailsFragment
import com.task.task.ui_module.posts.PostsListingFragment
import com.task.task.ui_module.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributePostsListingFragment(): PostsListingFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributePostsDetailsFragment(): PostDetailsFragment
}