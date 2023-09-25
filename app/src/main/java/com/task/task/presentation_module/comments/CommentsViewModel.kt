package com.task.task.presentation_module.comments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.task.domain.domain_module.posts.useCases.GetCommentsUseCase
import com.task.task.presentation_module.BaseViewModel
import com.task.task.presentation_module.events.CommentsEvents
import com.task.task.presentation_module.posts.mappers.PostsUiMapper
import javax.inject.Inject

/**
 * Created by Mohammed Taguldeen on 25/09/2023.
 */
class CommentsViewModel @Inject constructor(
    private val getCommentsUseCase: GetCommentsUseCase,
    private val mapper: PostsUiMapper,
) : BaseViewModel() {

    private val _comments = MutableLiveData<CommentsEvents>()
    val comments: LiveData<CommentsEvents>
        get() = _comments

    fun getComments(postId: Int) {
        executeSingle(useCase = getCommentsUseCase.run(postId),
            successConsumer = { data ->
                _comments.value = CommentsEvents.RetrievedCommentsListSuccessfully(
                    mapper.fromCommentsDomainToCommentsUiModel(data)
                )
            },
            loadingConsumer = {
                _comments.value = CommentsEvents.loading()
            },
            throwableConsumer = { error ->
                _comments.value = CommentsEvents.error(error)
            }
        )
    }
}