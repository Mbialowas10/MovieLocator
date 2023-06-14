package com.mbialowas.movielocator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mbialowas.movielocator.models.MovieResponse
import com.mbialowas.movielocator.network.Api
import com.mbialowas.movielocator.network.MovieManager
import com.mbialowas.movielocator.network.MovieService
import com.mbialowas.movielocator.screen.CharacterList
import com.mbialowas.movielocator.ui.theme.MovieLocatorTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieLocatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){

                    //var movieManager = MovieManager()
                    //var items = movieManager.movieResponse.value.results
                    //Log.d("Movies", "$items")
                    val movieService = Api.getInstance().create(MovieService::class.java)

                    val call = movieService.getPopularMovies(Api.API_KEY)

                    call.enqueue(object : Callback<MovieResponse>{
                        override fun onResponse(
                            call: Call<MovieResponse>,
                            response: Response<MovieResponse>
                        ) {
                            val body = response.body() // json parsed to kotlin objects
                            if (body != null) {
                                val movies = body?.results
                                var size = movies?.size
                            }
                        }

                        override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                            Toast.makeText(applicationContext, "Error reading JSON", Toast.LENGTH_SHORT).show()
                        }

                    })


                    //launch coroutine
//                    GlobalScope.launch {
//                        val result = movieService.getPopularMovies(Api.API_KEY)
//
//
//
//                        if (result != null){
//                            Log.d("Datum", result.body().toString())
//                        }else{
//                            Log.d("Datum", "No data pulled.")
//                        }
//                        Log.d("Datum", "Neither")
//                    }
                    CharacterList()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovieLocatorTheme {
        CharacterList()
    }
}