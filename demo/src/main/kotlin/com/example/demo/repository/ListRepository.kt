package com.example.demo.repository

import com.example.demo.data.MovieList
import com.example.demo.data.MovieListResponse
import org.bson.types.ObjectId
import org.springframework.data.domain.Example
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.query.FluentQuery
import java.util.function.Function

interface ListRepository : MongoRepository<MovieList, String> {

    override fun findAll(): MutableList<MovieList>;


    override fun <S : MovieList?> insert(entity: S): S {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String) {
        TODO("Not yet implemented")
    }


}