package com.mbialowas.movielocator.network

import com.mbialowas.movielocator.models.MovieResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieService {

    /**
     * Retrieves a list of popular movies.
     *
     * @param API_KEY the API key used to authenticate the API request.
     * @return a [MovieResponse] object containing the popular movies results.
     * @throws [IOException] if there is an error making the network request.
     * @throws [HttpException] if the API responds with an error status code.
     */
    //@GET("movie/popular")
    // suspend - indicates that it can be safely called from a coroutine without blocking the main thread.
    //fun getPopularMovies(
      //  @Query("api_key") API_KEY: String
    //): Call<MovieResponse>

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") API_KEY: String) : Response<MovieResponse>

    /**
     * Searches for movies based on a query string and page number.
     *
     * @param query the search query string.
     * @param page the page number of search results to retrieve.
     * @param API_KEY the API key used to authenticate the API request.
     * @return a [MovieResponse] object containing the search results.
     * @throws [IOException] if there is an error making the network request.
     * @throws [HttpException] if the API responds with an error status code.
     */
    @GET("search/movie")
    // suspend - indicates that it can be safely called from a coroutine without blocking the main thread.
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("api_key") API_KEY: String
    ): MovieResponse
}