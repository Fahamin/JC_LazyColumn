package com.forex.forexsignal.jetpackcomposeretrofithilt.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.forex.forexsignal.jetpackcomposeretrofithilt.api.ApiService
import com.forex.forexsignal.jetpackcomposeretrofithilt.model.Movie
import com.forex.forexsignal.jetpackcomposeretrofithilt.repository.MovieRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var movieListResponse:List<Movie> by mutableStateOf(listOf())
    private var errorMessage: String by mutableStateOf("")


    init {
        val repository = MovieRepository()
        viewModelScope.launch {
            repository.getMovieList()
            movieListResponse = repository.movieListResponse
            errorMessage = repository.errorMessage
        }
    }
}