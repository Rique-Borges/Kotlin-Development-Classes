package com.example.kotlinbasics

fun main(){
    val blueRoseVase = Vase("blue","Rose")
    val redRoseVase = blueRoseVase.copy(color = "Red")
    println(blueRoseVase)
    println(redRoseVase)
}
data class Vase(val color:String, val design:String)