package com.example.nucleus.ui

import androidx.lifecycle.ViewModel
import com.example.nucleus.data.PostsRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val postsRepository: PostsRepository) :
    ViewModel() {


}