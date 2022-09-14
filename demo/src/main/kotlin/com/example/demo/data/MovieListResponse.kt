package com.example.demo.data

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id

class MovieListResponse (

        val id: String,

        val idUser: String?,

        val label: String


    )