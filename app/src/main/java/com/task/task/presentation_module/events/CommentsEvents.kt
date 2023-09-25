package com.task.task.presentation_module.events

import com.task.task.presentation_module.posts.models.CommentsUi

sealed class CommentsEvents {
    object LoadingState : CommentsEvents()

    class ErrorState(val err: Throwable) : CommentsEvents()

    class RetrievedCommentsListSuccessfully(val commentsList: List<CommentsUi>) :
        CommentsEvents()

    companion object {

        fun loading(): CommentsEvents = LoadingState

        fun error(err: Throwable): CommentsEvents =
            ErrorState(err)

        fun retrievedCommentsListSuccessfully(commentsList: List<CommentsUi>): CommentsEvents =
            RetrievedCommentsListSuccessfully(commentsList)


    }
}