package com.task.task.ui_module.posts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.task.task.databinding.ItemLayoutBinding
import com.task.task.presentation_module.posts.models.PostsUi


class PostsListingAdapter (private val onPostClicked:Action) : ListAdapter<PostsUi, PostItemViewHolder>(
    PostsDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostItemViewHolder, position: Int) {
        holder.bind(getItem(position),onPostClicked)
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
        fun onPostClicked(post:PostsUi)
    }
}