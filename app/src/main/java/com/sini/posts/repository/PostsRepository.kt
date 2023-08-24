package com.sini.posts.repository

import com.sini.posts.api.ApiClient
import com.sini.posts.api.ApiInterface
import com.sini.posts.model.PostResponse
import com.sini.posts.model.Posts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostsRepository {
    val apiClient= ApiClient.buildClient(ApiInterface::class.java)
    suspend fun getPosts():Response<PostResponse>{
        return  withContext(Dispatchers.IO){
            apiClient.getposts()
        }
    }
}