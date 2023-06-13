package com.mbialowas.movielocator.api

import com.mbialowas.movielocator.models.MovieResponse
import com.mbialowas.movielocator.util.constants
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") API_KEY: String) : Response<MovieResponse>

    companion object{

        var apiService(): APIService? = null

        fun getInstance(): APIService{
            if (apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl(constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(APIService::class.java)
            }
            return apiService!!
        }
    }
}