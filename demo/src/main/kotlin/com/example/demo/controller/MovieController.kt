package com.example.demo.controller

import com.example.demo.data.Movie
import com.example.demo.data.MovieList
import com.example.demo.data.MovieListResponse
import com.example.demo.data.MovieResponse
import com.example.demo.repository.ListRepository
import com.example.demo.repository.MovieRepository
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/movies")
class MovieController (
    private val movieRepository: MovieRepository
) {
    @GetMapping
    fun getAllMovies(@RequestParam("idUser") idUser: String,
                     @RequestParam("idList") idList: String): ResponseEntity<List<MovieResponse>> {
        val movies = movieRepository.findAll()
        var usersMovie: MutableList<MovieResponse> = mutableListOf<MovieResponse>()
        for (item in movies) {
            if (item.idList == idList) {
                usersMovie.add(MovieResponse(item.id.toHexString(), item.title, item.idList))
            }
        }
        return ResponseEntity.ok(usersMovie)
    }

    @GetMapping("/get")
    fun getAllMoviesListUser(@RequestParam("id") id: String): ResponseEntity<List<Movie>> {
        val movies = movieRepository.findAll()
        var moviesSpecial : ArrayList<Movie> = arrayListOf()
        for (item in movies) {
            if (item.idList.equals(id)) {
                moviesSpecial.add(item)
            }
        }
        return ResponseEntity.ok(moviesSpecial)
    }

    @DeleteMapping("/delete")
    fun delete(@RequestParam("id") id: String): ResponseEntity<String> {
        val response = movieRepository.deleteById(id)
        return ResponseEntity.ok(response.toString())
    }

    @PostMapping("/insert")
    fun insert(@RequestParam("title") title: String,
               @RequestParam("idList") idList: String): ResponseEntity<String> {

        var objectId = ObjectId();
        val response = movieRepository.insert(Movie(objectId, idList, title))
        return ResponseEntity.ok(response.toString())

    }

}