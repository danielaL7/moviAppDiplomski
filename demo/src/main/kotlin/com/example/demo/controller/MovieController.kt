package com.example.demo.controller

import com.example.demo.data.Movie
import com.example.demo.data.MovieList
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
    fun getAllMovies(): ResponseEntity<List<Movie>> {
        val movies = movieRepository.findAll()
        return ResponseEntity.ok(movies)
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

    @GetMapping("/delete")
    fun delete(@RequestParam("id") id: String): ResponseEntity<String> {
        var objectId = ObjectId(id);
        val response = movieRepository.deleteById(id)
        return ResponseEntity.ok(response.toString())
    }

    @GetMapping("/insert")
    fun insert(@RequestParam("title") title: String,
               @RequestParam("idList") idList: String): ResponseEntity<String> {

        var objectId = ObjectId();
        val response = movieRepository.insert(Movie(objectId, idList, title))
        return ResponseEntity.ok(response.toString())

    }

}