package com.example.sandeepassignment.data.network

import com.example.sandeepassignment.data.model.infomodel.MovieInfoModel
import com.example.sandeepassignment.data.model.searchmodel.SearchModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("?")
    suspend fun getSearch(
        @Query("s") serach: String,
        @Query("apikey") apikey: String
    ): Response<SearchModel>

    @GET("?")
    suspend fun getMovieDetails(
        @Query("i") id: String,
        @Query("apikey") apikey: String
    ): Response<MovieInfoModel>

}