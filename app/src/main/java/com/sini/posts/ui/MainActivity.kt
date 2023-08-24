package com.sini.posts.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sini.posts.R
import com.sini.posts.databinding.ActivityMainBinding
import com.sini.posts.model.Posts
import com.sini.posts.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {
    val postsviewmodel:PostViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    val postdata:List<Posts> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        postsviewmodel.fetchPosts()
        postsviewmodel.errlivedata.observe(this, Observer{err->
            Toast.makeText(baseContext,err,Toast.LENGTH_LONG)

        })
        postsviewmodel.postsLiveData.observe(this, Observer {
            postlist->

            var  adapter=PostsAdapter(postlist?: emptyList(),this)
            binding.rvHome.adapter = adapter
            binding.rvHome.layoutManager = LinearLayoutManager(this@MainActivity)
        })
    }
}