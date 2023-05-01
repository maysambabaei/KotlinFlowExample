package com.bugeto.kotlinflows.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostRepository() {
    suspend fun getPosts():Flow<List<Post>>{
        return flow {
            val response = RetrofitConfig.service.getPosts()
            emit(response)
        }
    }
}