package com.example.kotlinbasics

fun main(){
    var age = 0
    println("insira sua idade")
    val enteredValue = readln()//Ler o que o usuário inseriu
    age = enteredValue.toInt() //converter para integer

    // Operadores de Comparação
    // (>)  Maior Que
    // (<)  Menor Que
    // (==) Igual
    // (>=) Maior ou Igual
    // (<=) Menor ou Igual

    if (age in 18..39){
        println("you can come in")
    }else if (age < 40) {
        println("you cannot come in, you're too old")
    }else{
        println("you cannot come in, you're too old")
    }
}