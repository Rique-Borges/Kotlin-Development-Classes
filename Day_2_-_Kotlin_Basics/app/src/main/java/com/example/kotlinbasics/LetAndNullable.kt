package com.example.kotlinbasics

fun main(){

    // var? = nullable string
    val name: String? = "Ella"
    name?.let {
        println(it.toUpperCase())
    }
}