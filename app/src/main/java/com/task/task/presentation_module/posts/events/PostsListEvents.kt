package com.task.task.presentation_module.posts.events

import com.task.task.presentation_module.posts.models.CommentsUi
import com.task.task.presentation_module.posts.models.PostsUi


/**
 * Created by Mohammed Taguldeen on 13/07/2023.
 */
sealed class PostsListEvents {
    object LoadingState : PostsListEvents()

    class ErrorState(val err: Throwable) : PostsListEvents()

    class RetrievedPostsListSuccessfully(val list: List<PostsUi>) : PostsListEvents()

    companion object {

        fun loading(): PostsListEvents = LoadingState

        fun error(err: Throwable): PostsListEvents =
            ErrorState(err)

        fun retrievedPostsListSuccessfully(postsList: List<PostsUi>): PostsListEvents =
            RetrievedPostsListSuccessfully(postsList)

    }
}