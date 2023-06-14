package com.mbialowas.movielocator.models

import com.mbialowas.movielocator.models.response.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

class MoviesRepository() {

    // method can be removed from MovieServices upon successful refactor?
    fun getPopularMovies(): MovieResponse = MovieResponse(arrayListOf())


}