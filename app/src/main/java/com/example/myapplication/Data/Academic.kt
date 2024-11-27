package com.example.myapplication.Data

data class Academic (
    val entitat: String,
    val anys: String
) {
    companion object{
        const val ARG_ACADEMIC = "academic"
    }
}