package com.task.domain.domain_module.posts.repository

import com.task.domain.domain_module.posts.models.CommentDomain
import com.task.domain.domain_module.posts.models.PostsDomain
import io.reactivex.Single

/**
 * Created by Mohammed Taguldeen on 23/09/2023.
 */
interface PostsRepository {

    fun getPosts():Single<List<PostsDomain>>

    fun getComments(postId:Int):Single<List<CommentDomain>>
}