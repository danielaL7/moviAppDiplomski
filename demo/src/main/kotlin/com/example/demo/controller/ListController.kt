package com.example.demo.controller

import com.example.demo.data.Movie
import com.example.demo.data.MovieList
import com.example.demo.repository.ListRepository
import com.example.demo.repository.MovieRepository
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/lists")
class ListController(
    private val listRepository: ListRepository,
    private val movieRepository: MovieRepository
) {

    @GetMapping
    fun getAllLists(): ResponseEntity<List<MovieList>> {

        val lists = listRepository.findAll()

        return ResponseEntity.ok(lists)
    }

    @GetMapping("/delete")
    fun delete(@RequestParam("id") id: String): ResponseEntity<String> {

        val movies = movieRepository.findAll()
        var moviesSpecial : ArrayList<Movie> = arrayListOf()
        for (item in movies) {
            if (item.idList.equals(id)) {
                movieRepository.deleteById(item.id.toString())
            }
        }

        val response = listRepository.deleteById(id)
        return ResponseEntity.ok(response.toString())
    }

    @GetMapping("/insert")
    fun insert(@RequestParam("idUser") idUser: String,
               @RequestParam("label") label: String): ResponseEntity<String> {

        var objectId = ObjectId();
        val response = listRepository.insert(MovieList(objectId, idUser, label))
        return ResponseEntity.ok(response.toString())

    }
}