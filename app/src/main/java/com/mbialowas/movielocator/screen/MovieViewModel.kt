package com.mbialowas.movielocator.screen

import androidx.lifecycle.ViewModel
import com.mbialowas.movielocator.models.MoviesRepository
import com.mbialowas.movielocator.models.response.Result


class MovieViewModel(private val respository: MoviesRepository): ViewModel() {
   fun getPopularMovies(): List<Result> {
       return respository.getPopularMovies().results!!
   }
}