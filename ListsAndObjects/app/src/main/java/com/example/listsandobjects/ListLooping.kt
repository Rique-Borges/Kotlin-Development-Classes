package com.example.listsandobjects

fun main(){
    val numbers = mutableListOf(1,2,3,4,5)
    for(i in 0 until numbers.size){
       numbers.set(i, numbers[i]*2)
        println(numbers[i])
    }
    println(numbers)
}