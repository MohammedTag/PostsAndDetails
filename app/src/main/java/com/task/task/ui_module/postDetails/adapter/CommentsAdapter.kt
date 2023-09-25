package com.task.task.ui_module.postDetails.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.task.task.databinding.ItemLayoutBinding
import com.task.task.presentation_module.posts.models.CommentsUi


class CommentsAdapter : ListAdapter<CommentsUi, CommentViewHolder>(
    CommentsDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    class CommentsDiffCallback : DiffUtil.ItemCallback<CommentsUi>() {
        override fun areItemsTheSame(oldItem: CommentsUi, newItem: CommentsUi): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CommentsUi, newItem: CommentsUi): Boolean {
            return oldItem.id == newItem.id
        }

    }
}