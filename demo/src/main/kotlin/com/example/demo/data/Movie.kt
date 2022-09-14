package com.example.demo.data

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Movie (

    @Id
    val id: ObjectId = ObjectId.get(),

    val title: String?,

    val idList: String?) {
}