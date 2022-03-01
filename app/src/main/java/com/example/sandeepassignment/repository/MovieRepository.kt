package com.example.sandeepassignment.repository

import com.example.sandeepassignment.data.model.infomodel.MovieInfoModel
import com.example.sandeepassignment.utils.Resource
import com.example.sandeepassignment.data.model.searchmodel.SearchModel

interface MovieRepository {

    suspend fun getMovies(string: String): Resource<SearchModel>
    suspend fun getMovieInfo(string: String): Resource<MovieInfoModel>?
}