package com.task.task.presentation_module.posts.mappers

import com.task.domain.domain_module.posts.models.CommentDomain
import com.task.domain.domain_module.posts.models.PostsDomain
import com.task.task.presentation_module.posts.models.CommentsUi
import com.task.task.presentation_module.posts.models.PostsUi

object PostsUiMapper {
    fun fromPostsDomainItemToPostsUiModel(postsList: List<PostsDomain>): List<PostsUi> {
        return postsList.map { postsDomain ->
            PostsUi(
                postsDomain.body,
                postsDomain.id,
                postsDomain.title,
                postsDomain.user
            )
        }
    }

    fun fromCommentsDomainToCommentsUiModel(commentsList: List<CommentDomain>): List<CommentsUi> =
        commentsList.map { domainComment ->
            CommentsUi(
                domainComment.body,
                domainComment.email,
                domainComment.id,
                domainComment.name,
                domainComment.post_id
            )
        }
}