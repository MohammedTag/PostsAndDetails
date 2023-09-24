package com.task.domain.domain_module.posts.useCases

import com.task.domain.domain_module.abstract_usecases.SingleUseCase
import com.task.domain.domain_module.posts.models.CommentDomain
import com.task.domain.domain_module.posts.models.PostsDomain
import com.task.domain.domain_module.posts.repository.PostsRepository
import com.task.domain.domain_module.qualifires.Background
import com.task.domain.domain_module.qualifires.Foreground
import io.reactivex.Scheduler
import io.reactivex.Single
import java.util.InputMismatchException
import javax.inject.Inject

/**
 * Created by Mohammed Taguldeen on 25/09/2023.
 */
class GetCommentsUseCase @Inject constructor(
    private val repo: PostsRepository,
    @Background private val backgroundScheduler: Scheduler,
    @Foreground private val foregroundScheduler: Scheduler,
) : SingleUseCase<List<CommentDomain>, Int>(
    backgroundScheduler,
    foregroundScheduler
) {
    override fun createSingle(input: Int?): Single<List<CommentDomain>> =
        if (input == null)
            Single.error(IllegalArgumentException())
        else
            repo.getComments(input)


}