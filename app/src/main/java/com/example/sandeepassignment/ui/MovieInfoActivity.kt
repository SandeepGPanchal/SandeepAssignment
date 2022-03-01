package com.example.sandeepassignment.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.sandeepassignment.R
import com.example.sandeepassignment.data.model.infomodel.MovieInfoModel
import com.example.sandeepassignment.databinding.ActivityMovieInfoBinding

class MovieInfoActivity : AppCompatActivity() {
    lateinit var activityMovieInfoBinding: ActivityMovieInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMovieInfoBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_movie_info)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);
        supportActionBar!!.setDisplayShowHomeEnabled(true);
        intiView()
    }

    private fun intiView() {
        val movieInfoModel = intent.getParcelableExtra<MovieInfoModel>("INFODATA")
        activityMovieInfoBinding.textViewYear.text = "(${movieInfoModel?.Year})"
        activityMovieInfoBinding.textViewDirector.text = movieInfoModel?.Director
        activityMovieInfoBinding.textViewStars.text = movieInfoModel?.Actors
        activityMovieInfoBinding.textViewTitle.text = movieInfoModel?.Title
        activityMovieInfoBinding.textViewTime.text = movieInfoModel?.Runtime
        activityMovieInfoBinding.textViewWriters.text = movieInfoModel?.Writer
        activityMovieInfoBinding.textViewReleaseDate.text = movieInfoModel?.Released
        activityMovieInfoBinding.textViewRate.text = movieInfoModel?.Rated
        activityMovieInfoBinding.textViewPlot.text = movieInfoModel?.Plot
        activityMovieInfoBinding.textViewGenre.text = movieInfoModel?.Genre

        if (!movieInfoModel?.Poster.isNullOrEmpty()) {
            if (!movieInfoModel?.Poster.equals("N/A")) {
                Glide.with(this@MovieInfoActivity)
                    .load(movieInfoModel?.Poster)
                    .into(activityMovieInfoBinding.imageView2)
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}