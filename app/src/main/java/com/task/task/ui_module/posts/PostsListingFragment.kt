package com.task.task.ui_module.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.task.task.databinding.FragmentPostsListingBinding
import com.task.task.presentation_module.posts.PostsViewModel
import com.task.task.presentation_module.posts.events.PostsListEvents
import com.task.task.presentation_module.posts.models.PostsUi
import com.task.task.ui_module.posts.adapter.PostsListingAdapter
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PostsListingFragment :
    DaggerFragment(), PostsListingAdapter.Action {


    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: PostsViewModel by viewModels { factory }

    private val adapter = PostsListingAdapter(this)

    private var _binding: FragmentPostsListingBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPostsListingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun bindViews() {
        with(binding) {
            pullToRefreshLayout.setOnRefreshListener {
                viewModel.getPosts()
                showLoading()
            }
            reposListingRv.adapter = adapter
            retryButton.setOnClickListener {
                viewModel.getPosts()
            }
        }
    }


    private fun hideLoading() {
        with(binding) {
            pullToRefreshLayout.isRefreshing = false
            shimmerLayout.apply {
                isVisible = false
                showShimmer(false)
                stopShimmer()
            }
        }
    }

    private fun showLoading() {
        with(binding) {
            shimmerLayout.apply {
                isVisible = true
                showShimmer(true)
                startShimmer()
            }

            retryButton.isVisible = false
            animationView.isVisible = false
            reposListingRv.isVisible = false
        }
    }

    private fun pullData() {
        with(viewModel) {
            getPosts()
            posts.observe(viewLifecycleOwner) { event ->
                when (event) {
                    is PostsListEvents.ErrorState -> {
                        hideLoading()
                        with(binding) {
                            animationView.isVisible = true
                            retryButton.isVisible = true
                            reposListingRv.isVisible = false
                        }
                    }

                    is PostsListEvents.LoadingState -> {
                        showLoading()
                    }

                    is PostsListEvents.RetrievedPostsListSuccessfully -> {
                        hideLoading()
                        binding.animationView.isVisible = false
                        binding.retryButton.isVisible = false

                        handleListBinding(event.list)
                    }

                    else -> {}
                }
            }
        }
    }

    private fun handleListBinding(list: List<PostsUi>) {
        with(list) {
            if (isEmpty()) {
                // FIXME:  should add empty view (probably not applicable in ourcase , there will always be result)
            } else {
                with(binding) {
                    reposListingRv.isVisible = true
                    adapter.submitList(list)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews()
        pullData()
    }

    override fun onPostClicked(post: PostsUi) {
        // TODO: should pass post to next fragment
    }
}