package com.example.sandeepassignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sandeepassignment.data.model.infomodel.MovieInfoModel
import com.example.sandeepassignment.data.model.searchmodel.SearchModel
import com.example.sandeepassignment.repository.MovieRepositoryImp
import com.example.sandeepassignment.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieRepositoryImp: MovieRepositoryImp) :
    ViewModel() {
    val movieLiveData = MutableLiveData<Resource<SearchModel>>()

    fun getMovies(string: String) {
        movieLiveData.postValue(Resource.loading())
        viewModelScope.launch {
            val result = movieRepositoryImp.getMovies(string)
            movieLiveData.postValue(result)
        }
    }

    val movieInfoLiveData = MutableLiveData<Resource<MovieInfoModel>>()

    fun getMovieInfo(string: String) {
        movieInfoLiveData.postValue(Resource.loading())
        viewModelScope.launch {
            val result = movieRepositoryImp.getMovieInfo(string)
            movieInfoLiveData.postValue(result)
        }
    }
}