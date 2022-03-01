package com.example.sandeepassignment.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sandeepassignment.adapter.MovieAdapter
import com.example.sandeepassignment.data.model.searchmodel.Search
import com.example.sandeepassignment.databinding.ActivityMovieBinding
import com.example.sandeepassignment.utils.DialogUtils
import com.example.sandeepassignment.utils.Status
import com.example.sandeepassignment.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieActivity : AppCompatActivity(), MovieAdapter.MovieNavigater {
    lateinit var activityMainBinding: ActivityMovieBinding
    val movieViewModel: MovieViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        initView()
    }

    private fun initView() {
        activityMainBinding.buttonSearch.setOnClickListener {
            val movieName = activityMainBinding.editTextSearch.text.toString()
            if (movieName.isNotEmpty()) {
                movieViewModel.getMovies(movieName)
            } else {
                Toast.makeText(this, "Please enter movie name", Toast.LENGTH_SHORT).show()
            }
        }

        movieViewModel.movieLiveData.observe(this) { response ->
            response?.let { resource ->
                when (resource.status) {
                    Status.LOADING -> {
                        DialogUtils.startProgressDialog(this)
                    }
                    Status.SUCCESS -> {
                        DialogUtils.stopProgressDialog()
                        setData(resource.data?.Search as ArrayList<Search>)
                    }
                    Status.ERROR -> {
                        DialogUtils.stopProgressDialog()
                        Toast.makeText(this, resource.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        movieViewModel.movieInfoLiveData.observe(this) { response ->
            response?.let { resource ->
                when (resource.status) {
                    Status.LOADING -> {
                        DialogUtils.startProgressDialog(this)
                    }
                    Status.SUCCESS -> {
                        DialogUtils.stopProgressDialog()
                        val intent = Intent(this, MovieInfoActivity::class.java)
                        intent.putExtra("INFODATA", resource.data)
                        startActivity(intent)
                    }
                    Status.ERROR -> {
                        DialogUtils.stopProgressDialog()
                        Toast.makeText(this, resource.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }


    }

    private fun setData(search: ArrayList<Search>) {
        val movieAdapter = MovieAdapter(this, this, search)
        val gridLayoutManager = GridLayoutManager(this, 2)
        activityMainBinding.movieRec.layoutManager = gridLayoutManager
        activityMainBinding.movieRec.adapter = movieAdapter
    }

    override fun ClickOnMovie(search: Search) {
        search?.let {
            movieViewModel.getMovieInfo(it.imdbID)
        }
    }
}