package com.task.task.ui_module.postDetails

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import coil.clear
import coil.load
import com.task.task.R
import com.task.task.databinding.FragmentPostDetailsBinding
import com.task.task.presentation_module.comments.CommentsViewModel
import com.task.task.presentation_module.events.CommentsEvents
import com.task.task.presentation_module.posts.models.CommentsUi
import com.task.task.presentation_module.posts.models.PostsUi
import com.task.task.ui_module.postDetails.adapter.CommentsAdapter
import com.task.task.ui_module.utils.getInitials
import com.task.task.ui_module.utils.isUnknownUser
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PostDetailsFragment : DaggerFragment() {

    private val args: PostDetailsFragmentArgs by navArgs()

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: CommentsViewModel by viewModels { factory }

    private var _binding: FragmentPostDetailsBinding? = null
    private val binding get() = _binding!!

    private val adapter = CommentsAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPostDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews()
        initObservers()
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
            commentsRv.isVisible = false
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

    private fun initObservers() {
        viewModel.getComments(args.post.id)
        viewModel.comments.observe(viewLifecycleOwner) { event ->
            when (event) {
                is CommentsEvents.ErrorState -> {
                    showRetryState()
                }

                CommentsEvents.LoadingState -> {
                    showLoading()
                }

                is CommentsEvents.RetrievedCommentsListSuccessfully -> {
                    hideLoading()
                    binding.animationView.isVisible = false
                    binding.retryButton.isVisible = false
                    handleCommentsBinding(event.commentsList)
                }
            }
        }
    }

    private fun showRetryState() {
        hideLoading()
        with(binding) {
            animationView.isVisible = true
            retryButton.isVisible = true
            commentsRv.isVisible = false
        }
    }

    private fun handleCommentsBinding(list: List<CommentsUi>) {
        with(list) {
            if (isEmpty()) {
                // FIXME:  should add empty view for no comments case
            } else {
                with(binding) {
                    commentsRv.isVisible = true
                    adapter.submitList(list)
                }
            }
        }
    }

    private fun bindViews() {
        with(binding) {
            retryButton.setOnClickListener {
                viewModel.getComments(args.post.id)
            }
            pullToRefreshLayout.setOnRefreshListener {
                viewModel.getComments(args.post.id)
                showLoading()
            }
            postDetails.avatarIv.load(
                AppCompatResources.getDrawable(
                    requireContext(),
                    R.drawable.baseline_person_search_24
                )
            )

            postDetails.titleTv.text = args.post.title
            postDetails.DescTv.text = args.post.body
            commentsRv.adapter = adapter
            bindUserName(args.post.user.name)
        }
    }

    private fun bindUserName(name: String) {

        binding.apply {

            if (name.isUnknownUser()
            ) {
                binding.postDetails.avatarIv.load(
                    AppCompatResources.getDrawable(
                        requireContext(),
                        R.drawable.baseline_person_search_24
                    )
                )
                setUpUserNameTextView(
                    resources.getText(R.string.unknown_user).toString()
                )
            } else {
                binding.postDetails.avatarIv.clear()
                setUpUserNameTextView(args.post.user.name)
                setAvatarBackground(binding)
            }
        }
    }

    private fun setUpUserNameTextView(name: String) {
        binding.postDetails.NameTv.apply {
            setTypeface(null, Typeface.BOLD_ITALIC)
            isVisible = true
            text = if (name.isUnknownUser()) name else ""
        }
        binding.postDetails.OwnerNameTv.text = if (name.isUnknownUser()) "" else name.getInitials()
    }

    private fun setAvatarBackground(binding: FragmentPostDetailsBinding) {
        binding.postDetails.avatarIv.background =
            context?.getDrawable(R.drawable.bg_white_15_round_corners)
        binding.postDetails.avatarIv.apply {
            val backgroundDrawable =
                AppCompatResources.getDrawable(
                    context,
                    R.drawable.bg_white_15_round_corners
                )?.mutate()
            backgroundDrawable?.let {
                DrawableCompat.setTint(
                    it,
                    ContextCompat.getColor(context, R.color.colorAccent)
                )
            }
            background = backgroundDrawable
        }
    }
}