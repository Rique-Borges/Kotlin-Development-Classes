package com.example.kotlinbasics

fun main(){
    print("Enter your age as a whole number: ")
    // Pedir entrada do usuário
    val read = readln()
    // Converter entrada do usuário para Int
    var age = read.toInt()

    // Checar a idade do usuário
    if (age in 18..40){
        println("You may enter the club")
    } else if (age >= 40){
        println("You cannot go into the club, please go home.")
    }else{
        println("Age not verified. Please contact support.")
    }
}