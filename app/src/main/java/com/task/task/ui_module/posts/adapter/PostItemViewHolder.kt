package com.task.task.ui_module.posts.adapter

import androidx.recyclerview.widget.RecyclerView
import com.task.task.databinding.ItemLayoutBinding
import com.task.task.presentation_module.posts.models.PostsUi

class PostItemViewHolder(private val binding: ItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PostsUi, onClickeDelegate: PostsListingAdapter.Action) {
        itemView.apply {
            with(item) {
//                binding.avatarIv.load()
                binding.OwnerNameTv.text = title
                binding.NameTv.text = body
//                binding.DescTv.text = body
                setOnClickListener {
                    onClickeDelegate.onPostClicked(this)
                }
            }
        }
    }
}