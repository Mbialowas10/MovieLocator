package com.mbialowas.movielocator.network

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.mbialowas.movielocator.models.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieManager {
//    // patch retrofit together and get a response
//
//    // get response and make it available to other class
//    private val _moviesResponse = mutableStateOf(MovieResponse())
//    val movieResponse: State<MovieResponse>
//        @Composable get() = remember{
//            _moviesResponse
//        }
//
//    init{
//        getMovies()
//    }
//    private fun getMovies(){
//
//        //val service = Api.retrofitService.getPopularMovies(Api.API_KEY)
//
//
//        //service.enqueue(object : Callback<MovieResponse> {
//            override fun onResponse(
//                call: Call<MovieResponse>,
//                response: Response<MovieResponse>
//            ) {
//                if (response.isSuccessful){
//                    _moviesResponse.value = response.body()!!
//                    Log.d("MJB", "${_moviesResponse.value}")
//                }else{
//                    Log.d("MJB_error", "$response")
//                }
//            }
//
//            override fun onFailure(
//                call: Call<MovieResponse>,
//                t: Throwable) {
//                Log.d("errorMe","${t.printStackTrace()}")
//            }
//        })
//    }
}