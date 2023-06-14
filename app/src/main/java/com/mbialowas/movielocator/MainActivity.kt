package com.mbialowas.movielocator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mbialowas.movielocator.models.response.MovieResponse
import com.mbialowas.movielocator.network.Api
import com.mbialowas.movielocator.network.MovieService
import com.mbialowas.movielocator.screen.CharacterList
import com.mbialowas.movielocator.screen.MovieViewModel
import com.mbialowas.movielocator.ui.theme.MovieLocatorTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : ComponentActivity() {
    lateinit var moviesList: List<Any>

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
                                if (movies != null) {
                                    moviesList = movies
                                }

                                // attempt to pass movies to composable fx
                                
                            }
                        }

                        override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                            Toast.makeText(applicationContext, "Error reading JSON", Toast.LENGTH_SHORT).show()
                        }
                        
                    })
                    //MovieList(movies = moviesList)

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
                    MovieListingScreen()

                }
            }
        }
    }
}

@Composable
fun MovieListingScreen(){
    // view holds reference to viewModel
    val movieViewModel:MovieViewModel = viewModel() // bind viewModel to composable MovieListingScreen
    val movies = movieViewModel.getPopularMovies()

}

