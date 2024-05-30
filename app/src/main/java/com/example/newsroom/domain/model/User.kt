package com.example.newsroom.domain.model

data class User(val userid: String, val Email: String, val Name: String, val userVersion: String) {
    constructor() : this("", "", "", "")

    fun toMap(): Map<String, Any> {
        return mapOf(
            "userid" to userid,
            "Email" to Email,
            "Name" to Name,
            "userVersion" to userVersion
        )
    }
}
