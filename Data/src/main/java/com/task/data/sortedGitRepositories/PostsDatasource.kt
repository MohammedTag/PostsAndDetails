package com.task.data.sortedGitRepositories


import com.task.domain.domain_module.posts.models.CommentDomain
import com.task.domain.domain_module.posts.models.PostsDomain
import com.task.domain.domain_module.posts.repository.PostsRepository
import com.task.domain.domain_module.user.models.UserDomain
import com.task.remote.di.services.posts.PostsService
import com.task.remote.di.services.user.UsersService
import com.task.remote.di.services.user.models.UserResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Mohammed Taguldeen on 23/09/2023.
 */
class PostsDatasource @Inject constructor(
    private val postsService: PostsService,
    private val usersService: UsersService,
) :
    PostsRepository {
    val posts = mutableListOf<PostsDomain>()
    override fun getPosts(): Single<List<PostsDomain>> {

        return postsService.getPosts().flatMap { response ->
            Single.just(response.map { post ->
                PostsDomain(
                    post.body,
                    post.id,
                    post.title,
                    usersService.getUser(post.user_id).onErrorResumeNext {
                        Single.just(UserResponse("N/A", "N/A", post.user_id, "Unknown User", "N/A"))
                    }.blockingGet().toDomain()
                )
            }
            )
        }
    }


    override fun getComments(postId: Int): Single<List<CommentDomain>> =
        postsService.getPostDetails(postId)
            .map { response -> response.map { commentResponse -> commentResponse.toDomain() } }

}