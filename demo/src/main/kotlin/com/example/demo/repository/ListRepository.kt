package com.example.demo.repository

import com.example.demo.data.MovieList
import org.springframework.data.mongodb.repository.MongoRepository

interface ListRepository : MongoRepository<MovieList, String> {

    override fun findAll(): MutableList<MovieList>;


    override fun <S : MovieList?> insert(entity: S): S {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String) {
        TODO("Not yet implemented")
    }


}