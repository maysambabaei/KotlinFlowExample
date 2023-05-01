package com.bugeto.kotlinflows.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bugeto.kotlinflows.R
import com.bugeto.kotlinflows.data.PostRepository
import com.bugeto.kotlinflows.databinding.ActivityMainBinding
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val postAdapter = PostAdapter()
    private val postRepository = PostRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

       binding.rvPosts.adapter = postAdapter
        binding.rvPosts.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        lifecycleScope.launch {
            postRepository.getPosts().collect {
                postAdapter.updateData(it)
                postAdapter.notifyDataSetChanged()
            }
        }

    }
}