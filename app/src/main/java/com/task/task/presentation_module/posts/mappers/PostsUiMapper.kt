package com.task.task.presentation_module.posts.mappers

import com.task.domain.domain_module.posts.models.CommentDomain
import com.task.domain.domain_module.posts.models.PostsDomain
import com.task.domain.domain_module.user.models.UserDomain
import com.task.task.presentation_module.posts.models.CommentsUi
import com.task.task.presentation_module.posts.models.PostsUi
import com.task.task.presentation_module.posts.models.UserUi

object PostsUiMapper {
    fun fromPostsDomainItemToPostsUiModel(postsList: List<PostsDomain>): List<PostsUi> {
        return postsList.map { postsDomain ->
            PostsUi(
                postsDomain.body,
                postsDomain.id,
                postsDomain.title,
                fromUserDomainToUserUi(postsDomain.user)
            )
        }
    }

    fun fromCommentsDomainToCommentsUiModel(commentsList: List<CommentDomain>): List<CommentsUi> =
        commentsList.map { domainComment ->
            CommentsUi(
                body = domainComment.body,
                email = domainComment.email,
                id = domainComment.id,
                name = domainComment.name,
                post_id = domainComment.post_id
            )
        }

    fun fromUserDomainToUserUi(userDomain: UserDomain): UserUi =
        with(userDomain) { UserUi(email, gender, id, name, status) }
}