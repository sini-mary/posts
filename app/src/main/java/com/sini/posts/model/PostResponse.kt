package com.sini.posts.model

data class PostResponse(
     var posts: List<Posts>,
    var total:Int,
    var skip:Int,
    var limit:Int,
    val size:String
)
