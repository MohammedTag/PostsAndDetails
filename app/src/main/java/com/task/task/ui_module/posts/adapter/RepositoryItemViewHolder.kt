package com.task.task.ui_module.posts.adapter

import androidx.recyclerview.widget.RecyclerView
import com.task.task.databinding.ItemLayoutBinding
import com.task.task.presentation_module.posts.models.PostsUi

class RepositoryItemViewHolder(private val binding: ItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PostsUi) {
        itemView.apply {
            with(item) {
//                binding.avatarIv.load()
                binding.OwnerNameTv.text = title
                binding.NameTv.text = title
                binding.DescTv.text = body
                setOnClickListener {
                }
            }
        }
    }
}