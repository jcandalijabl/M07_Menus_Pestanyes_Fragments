package com.example.myapplication.Data

data class Personal (
    val nom: String,
    val cognom: String,
    val dataNaixement: String,
    val llocNaixement: String
) {
    companion object{
        const val ARG_PERSONAL = "personal"
    }
}