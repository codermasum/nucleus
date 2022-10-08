package com.example.nucleus.data

import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Singleton
class PostsRepository @Inject constructor(
    private val postsDao: PostsDao,
    private val foodiumService: ApiService
) {


}
