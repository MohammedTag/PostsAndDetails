package com.task.task.ui_module.posts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.task.task.databinding.ItemLayoutBinding
import com.task.task.presentation_module.posts.models.PostsUi


class PostsListingAdapter : ListAdapter<PostsUi, RepositoryItemViewHolder>(
    PostsDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryItemViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RepositoryItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    class PostsDiffCallback : DiffUtil.ItemCallback<PostsUi>() {
        override fun areItemsTheSame(oldItem: PostsUi, newItem: PostsUi): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PostsUi, newItem: PostsUi): Boolean {
            return oldItem.id == newItem.id
        }

    }

    interface Action{
        fun onItemClicked(id:Int)
    }
}