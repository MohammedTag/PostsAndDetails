package com.task.data.sortedGitRepositories


import com.task.domain.domain_module.posts.models.CommentDomain
import com.task.domain.domain_module.posts.models.PostsDomain
import com.task.domain.domain_module.posts.repository.PostsRepository
import com.task.remote.di.services.posts.PostsService
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Mohammed Taguldeen on 23/09/2023.
 */
class PostsDatasource @Inject constructor(
    private val postsService: PostsService,
) :
    PostsRepository {
    override fun getPosts(): Single<List<PostsDomain>> =
        postsService.getPosts().map { response -> response.map { it.toDomain() } }

    override fun getComments(postId: Int): Single<List<CommentDomain>> =
        postsService.getPostDetails(postId)
            .map { response -> response.map { commentResponse -> commentResponse.toDomain() } }

}