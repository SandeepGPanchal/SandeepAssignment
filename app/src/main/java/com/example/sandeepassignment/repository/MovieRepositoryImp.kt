package com.example.sandeepassignment.repository

import com.example.sandeepassignment.data.model.infomodel.MovieInfoModel
import com.example.sandeepassignment.data.model.searchmodel.SearchModel
import com.example.sandeepassignment.data.network.MovieApi
import com.example.sandeepassignment.utils.Constants.Companion.KEY
import com.example.sandeepassignment.utils.Resource
import java.io.IOException
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(private val movieApi: MovieApi) :
    MovieRepository {


    override suspend fun getMovies(string: String): Resource<SearchModel> {
        return try {
            val response = movieApi.getSearch(string, KEY)
            val result = response.body()

            if (response.isSuccessful && result != null) {
                Resource.success(result)
            } else {
                Resource.error(response.message(), null)
            }

        } catch (e: IOException) {
            Resource.error(e.message.toString(), null)
        }
    }

    override suspend fun getMovieInfo(string: String): Resource<MovieInfoModel>? {
        return try {
            val response = movieApi.getMovieDetails(string, KEY)
            val result = response.body()

            if (response.isSuccessful && result != null) {
                Resource.success(result)
            } else {
                Resource.error(response.message(), null)
            }

        } catch (e: IOException) {
            Resource.error(e.message.toString(), null)
        }
    }

}