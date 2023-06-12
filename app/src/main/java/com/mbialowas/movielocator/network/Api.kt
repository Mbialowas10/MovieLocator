package com.mbialowas.movielocator.network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Api {

    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val IMAGE_PATH = "https://image.tmdb.org/t/p/w500"
    const val API_KEY = "64cf247f99529bf00f1dbfd4304613d3"

//    private val moshi = Moshi.Builder()
//        .add(KotlinJsonAdapterFactory())
//        .build()
//
//    private val retrofit = Retrofit.Builder()
//        .addConverterFactory(MoshiConverterFactory.create(moshi))
//        .baseUrl(BASE_URL)
//        .build()
//
//    val retrofitService: MovieService by lazy {
//        retrofit.create(MovieService::class.java)
//    }

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}