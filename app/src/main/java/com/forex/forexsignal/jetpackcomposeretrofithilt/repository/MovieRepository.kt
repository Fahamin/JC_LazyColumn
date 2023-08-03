package com.forex.forexsignal.jetpackcomposeretrofithilt.repository

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.forex.forexsignal.jetpackcomposeretrofithilt.api.ApiService
import com.forex.forexsignal.jetpackcomposeretrofithilt.model.Movie
import kotlinx.coroutines.launch

class MovieRepository {
    var movieListResponse: List<Movie> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    suspend fun getMovieList() {
        val apiService = ApiService.getInstance()
        try {
            val movieList = apiService.getMovies()
            movieListResponse = movieList
        } catch (e: Exception) {
            errorMessage = e.message.toString()

        }
    }
}