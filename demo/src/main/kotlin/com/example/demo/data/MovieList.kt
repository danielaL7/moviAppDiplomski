package com.example.demo.data

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class MovieList (

    @Id
    val id: ObjectId = ObjectId.get(),

    val idUser: String?,

    val label: String) {


}