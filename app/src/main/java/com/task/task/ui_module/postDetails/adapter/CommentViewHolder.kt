package com.task.task.ui_module.postDetails.adapter

import android.graphics.Typeface
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.task.task.R
import com.task.task.databinding.ItemLayoutBinding
import com.task.task.presentation_module.posts.models.CommentsUi
import com.task.task.ui_module.utils.getInitials


class CommentViewHolder(private val binding: ItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CommentsUi) {
        itemView.apply {
            with(item) {
                itemView.background = context.getDrawable(R.drawable.bg_white_15_round_corners)
                binding.avatarIv.apply {
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
                binding.OwnerNameTv.text = name.getInitials()
                binding.NameTv.apply {
                    setTypeface(null, Typeface.BOLD_ITALIC)
                    text = name
                }
                binding.DescTv.text = body
            }
        }
    }
}