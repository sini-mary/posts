package com.sini.posts.api

import com.sini.posts.model.PostResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET ("/posts")
    suspend fun getposts():Response<PostResponse>
}