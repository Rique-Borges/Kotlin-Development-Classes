package com.example.functionsandobjects

data class CoffeeDetails(
    val sugarCount: Int,
    val name: String,
    val size: String,
    val creamAmount:Int)


fun main(){
    val coffeeforrike = CoffeeDetails(0,"Rike", "Large", 1 )
    makeCoffee(coffeeforrike)
}
fun coffeeDetails() {
    // Chamando a função makeCoffee
    println("Who is this coffee for?")
    var name = readln()
    println("How many spoons of sugar for you, $name?")
    var sugarCount = readln().toInt()

    //makeCoffee(sugarCount, name)
}

// Definindo A função makeCoffee
fun makeCoffee(coffeeDetails: CoffeeDetails) {
    if (coffeeDetails.sugarCount == 1) {
        println("${coffeeDetails.size} Coffee with ${coffeeDetails.sugarCount} spoon of sugar for ${coffeeDetails.name}")
    } else if (coffeeDetails.sugarCount > 1) {
        println("${coffeeDetails.size} Coffee with ${coffeeDetails.sugarCount} spoons of sugar for ${coffeeDetails.name}")
    } else {
        println("${coffeeDetails.size} Coffee with no sugar for ${coffeeDetails.name}")
    }
}