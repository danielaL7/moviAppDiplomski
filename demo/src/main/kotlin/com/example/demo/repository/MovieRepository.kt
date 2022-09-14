package com.example.demo.repository

import com.example.demo.data.Movie
import com.example.demo.data.MovieList
import org.apache.commons.logging.Log
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface MovieRepository : MongoRepository<Movie, String> {

    override fun findAll(): MutableList<Movie>;

    override fun <S : Movie?> insert(entity: S): S

    override fun deleteById(id: String) {
        TODO("Not yet implemented")
    }
}