package com.example.kotlinbasics

fun main(){
    var name = "Henrique"
    println(name + " Ribeiro Borges")
    name = "Uma alta\n" +
            "  quantidade\n" +
            "  de parágrafos \n" +
            " podem ser armazenados\n" +
            "  em strings"
    println(name.uppercase()) // Vai printar a variável name em caixa alta

}