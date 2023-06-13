package com.mbialowas.movielocator.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mbialowas.movielocator.api.APIService
import com.mbialowas.movielocator.models.MovieResponse
import com.mbialowas.movielocator.util.constants
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class TopViewModel: ViewModel() {
    private val _movieList = mutableStateListOf<Response<MovieResponse>>()
    var errorMessage: String by mutableStateOf("")
    val movieList: SnapshotStateList<Response<MovieResponse>>
        get() = _movieList

    fun getMovieList(){
        viewModelScope.launch{
            val apiService = APIService.getInstance()

            try{
                _movieList.clear()
                _movieList.addAll(listOf(apiService.getPopularMovies(constants.API_KEY)))
            }catch (e: Exception){
                errorMessage = e.message.toString()
            }
        }
    }
}