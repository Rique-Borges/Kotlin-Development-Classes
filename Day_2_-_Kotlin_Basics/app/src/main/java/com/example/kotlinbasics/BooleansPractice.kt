package com.example.kotlinbasics

fun main(){
    val myTrue = true
    val myOtherTrue = true
    val myFalse = false
    val myOtherFalse = false
    println(myTrue || myFalse) // this will be true
    println(myTrue && myFalse) // this will be false
    println(!myTrue) // this will be false
    println(myTrue != myOtherTrue) // this will be false
    println(myTrue == myOtherTrue) // this will be true
    println(myTrue == myOtherFalse) // this will be false
    println(myFalse == myOtherFalse) // this will be true
}