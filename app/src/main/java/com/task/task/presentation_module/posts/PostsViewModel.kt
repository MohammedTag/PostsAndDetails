package com.task.task.presentation_module.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.task.domain.domain_module.posts.useCases.GetPostsUseCase
import com.task.task.presentation_module.BaseViewModel
import com.task.task.presentation_module.posts.events.PostsListEvents
import com.task.task.presentation_module.posts.mappers.PostsUiMapper
import javax.inject.Inject

/**
 * Created by Mohammed Taguldeen on 13/07/2023.
 */
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase,
    private val mapper: PostsUiMapper
) : BaseViewModel() {

    private val _posts = MutableLiveData<PostsListEvents>()
    val posts: LiveData<PostsListEvents>
        get() = _posts

    fun getPosts() {
        executeSingle(useCase = getPostsUseCase.run(null),
            successConsumer = { data ->
                _posts.value = PostsListEvents.retrievedPostsListSuccessfully(
                    mapper.fromPostsDomainItemToPostsUiModel(data)
                )
            },
            loadingConsumer = {
                _posts.value = PostsListEvents.loading()
            },
            throwableConsumer = { error ->
                _posts.value = PostsListEvents.error(error)
            }
        )
    }
}