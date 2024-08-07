package com.example.functionsandobjects

fun main(){
    var capital = Livro(titulo = "O Capital", anoPublicacao = "14/09/1867", autor = "Karl Marx")
    println("${capital.titulo}, publicado em ${capital.anoPublicacao} por ${capital.autor}")
    capital.titulo = "O Capital. Crítica da Economia Política"
    println("${capital.titulo}, publicado em ${capital.anoPublicacao} por ${capital.autor}")
}