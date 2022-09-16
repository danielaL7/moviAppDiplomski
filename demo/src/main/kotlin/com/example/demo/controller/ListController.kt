package com.example.demo.controller

import com.example.demo.data.Movie
import com.example.demo.data.MovieList
import com.example.demo.data.MovieListResponse
import com.example.demo.repository.ListRepository
import com.example.demo.repository.MovieRepository
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/lists")
class ListController(

    private val listRepository: ListRepository,
    private val movieAlternativeRepository: MovieRepository

) {

    @GetMapping
    fun getAllLists(@RequestParam("id") id: String): ResponseEntity<List<MovieListResponse>> {
        println("uslo")
        val lists = listRepository.findAll()
        var userList: MutableList<MovieListResponse> = mutableListOf<MovieListResponse>()


        for (item in lists) {
            if (item.idUser == id) {
                userList.add(MovieListResponse(item.id.toHexString(), item.idUser, item.label))
            }

        }
        return ResponseEntity.ok(userList)

    }

        @GetMapping("/delete")
        fun delete(@RequestParam("idUser") id: String, @RequestParam("label") label: String): ResponseEntity<String> {
            println("idUser " + id)
            println("label " + label)

            val lists = listRepository.findAll()
            var responese: String = ""

            for (item in lists) {

                if (item.label == label && item.idUser == id) {
                    println("pronasao")

                    responese = listRepository.deleteById(item.id.toHexString()).toString()
                }
            }

            return ResponseEntity.ok(responese.toString())
        }

        @GetMapping("/insert")
        fun insert(
            @RequestParam("idUser") idUser: String,
            @RequestParam("label") label: String
        ): ResponseEntity<String> {

            var objectId = ObjectId();
            val response = listRepository.insert(MovieList(objectId, idUser, label))
            return ResponseEntity.ok(response.toString())

        }


}