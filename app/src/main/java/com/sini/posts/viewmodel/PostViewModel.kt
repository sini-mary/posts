package com.sini.posts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sini.posts.model.Posts
import com.sini.posts.repository.PostsRepository
import kotlinx.coroutines.launch

class PostViewModel:ViewModel() {
    val postsrepo= PostsRepository()
    val postsLiveData= MutableLiveData<List<Posts>>()
    val errlivedata= MutableLiveData<String>()
    fun fetchPosts(){
        viewModelScope.launch {
            val response= postsrepo.getPosts()
            if(response.isSuccessful){
                postsLiveData.postValue(response.body()?.posts)
            }
            else{
                errlivedata.postValue(response.errorBody()?.string())
            }
        }
    }
}