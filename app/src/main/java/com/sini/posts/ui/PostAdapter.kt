package com.sini.posts.ui

import android.view.LayoutInflater
import com.sini.posts.databinding.PostsBinding


import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sini.posts.model.Posts

class PostsAdapter(var postlists:List<Posts>,mainActivity: MainActivity):RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsAdapter.PostsViewHolder {
        val binding= PostsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val postsss=postlists[position]
        holder.bind(postsss)
    }

    override fun getItemCount(): Int {
        return postlists.size
    }



  inner  class PostsViewHolder(val binding:PostsBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(posts: Posts){
            binding.apply{
                tvBody.text=posts.body
                tvId.text=posts.id.toString()
                tvUserId.text=posts.userId.toString()
                tvTitle.text=posts.title.toString()


            }
        }
    }
}