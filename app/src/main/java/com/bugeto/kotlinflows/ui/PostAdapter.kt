package com.bugeto.kotlinflows.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bugeto.kotlinflows.R
import com.bugeto.kotlinflows.data.Post
import com.bugeto.kotlinflows.databinding.PostsItemBinding

class PostAdapter() : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private var _posts: List<Post> = emptyList()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = PostsItemBinding.bind(itemView)
        fun bind(post: Post) {
            with(binding) {
                tvUserIdData.text = post.userId.toString()
                tvIdData.text = post.id.toString()
                tvTitleData.text = post.title
                tvBodyData.text = post.body
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.posts_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = _posts[position]
        holder.bind(post)
    }

    override fun getItemCount() = _posts.size

    fun updateData(posts: List<Post>) {
        _posts = posts
    }

}