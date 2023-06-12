package com.mbialowas.movielocator.models




data class MovieResponse(

    val page: Int? = null,
    val results: List<Result>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
) {

}