package com.example.listsandobjects

fun main(){
    var fruitsList = mutableListOf("Banana", "Apple", "Pear", "Melon", "Grape")
    println(fruitsList)
    fruitsList.add("Blueberry")
    println(fruitsList)
    fruitsList.remove("Pear")
    println(fruitsList)
    var bananaCheck = fruitsList.contains("Banana")
    if (bananaCheck){
        println("There is a Banana in the list")
    }else{
        println("There is not Banana in the list")
    }
}