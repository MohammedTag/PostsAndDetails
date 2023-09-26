package com.task.task.ui_module.posts.adapter

import android.graphics.Typeface
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.clear
import coil.load
import com.task.task.R
import com.task.task.databinding.ItemLayoutBinding
import com.task.task.presentation_module.posts.models.PostsUi
import com.task.task.ui_module.utils.getInitials
import com.task.task.ui_module.utils.isUnknownUser

class PostItemViewHolder(private val binding: ItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PostsUi, onClickDelegate: PostsListingAdapter.Action) {
        itemView.apply {
            with(item) {
                itemView.background = context.getDrawable(R.drawable.bg_white_15_round_corners)
                bindUserName(item)
                binding.titleTv.text = title
                binding.NameTv.apply {
                    setTypeface(null, Typeface.BOLD_ITALIC)
                    isVisible = true
                    text = user.name
                }
                binding.DescTv.text = body
                setOnClickListener {
                    onClickDelegate.onPostClicked(this)
                }
            }
        }
    }

    private fun bindUserName(item: PostsUi) {
        itemView.apply {
            with(item) {
                if (user.name.isUnknownUser()) {
                    binding.avatarIv.load(
                        AppCompatResources.getDrawable(
                            context,
                            R.drawable.baseline_person_search_24
                        )
                    )
                    binding.OwnerNameTv.text = ""
                } else {
                    binding.avatarIv.clear()
                    binding.OwnerNameTv.text = user.name.getInitials()
                }
            }
        }
    }
}