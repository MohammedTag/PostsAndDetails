package com.task.domain.domain_module.posts.useCases

import com.task.domain.domain_module.abstract_usecases.SingleUseCase
import com.task.domain.domain_module.posts.models.PostsDomain
import com.task.domain.domain_module.qualifires.Background
import com.task.domain.domain_module.qualifires.Foreground
import com.task.domain.domain_module.posts.repository.PostsRepository
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Mohammed Taguldeen on 23/09/2023.
 */
class GetPostsUseCase @Inject constructor(
    private val repo: PostsRepository,
    @Background private val backgroundScheduler: Scheduler,
    @Foreground private val foregroundScheduler: Scheduler
) : SingleUseCase<List<PostsDomain>, Unit>(
    backgroundScheduler,
    foregroundScheduler
) {
    override fun createSingle(input: Unit?): Single<List<PostsDomain>> =
        repo.getPosts()

}