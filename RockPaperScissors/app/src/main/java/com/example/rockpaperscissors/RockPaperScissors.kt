package com.example.rockpaperscissors


fun freaky(){
    println("Do you wish to play Rock Paper Scissors? \n 1. Yes \n 2. No")
var entradaJogador = readln().toInt()
    while (entradaJogador == 1){
    println("Rock, paper or scissors? Enter your choice! \n 1. Rock \n 2. Paper \n 3. Scissors")
    val read = readln()
    var playerchoice = read
    var computerchoice = ""

    val randomNumber = (1..3).random()
    when (randomNumber) {
        1 -> {
            computerchoice = "Rock"
        }
        2 -> {
            computerchoice = "Paper"
        }
        3 -> {
            computerchoice = "Scissors"
        }
        else -> {
            println("Invalid Choice")
        }
    }
    println("The computer chooses: " + computerchoice+ "!")
    when (playerchoice) {
        "1" -> {
            playerchoice = "Rock"
        }
        "2" -> {
            playerchoice = "Paper"
        }
        "3" -> {
            playerchoice = "Scissors"
        }
        else -> {
            println("Invalid Choice")
        }
    }
    println("The player chooses: " + playerchoice+ "!")

    val winner = when{
        playerchoice == computerchoice -> "Tie"
        playerchoice == "Rock" && computerchoice == "Scissors" ->"Player"
        playerchoice == "Paper" && computerchoice == "Rock" ->"Player"
        playerchoice == "Scissors" && computerchoice == "Paper" ->"Player"
        else -> "Computer"
    }
    if (winner == "Tie"){
        println("It's a TIE!")
    } else if (winner == "Player"){
        println("Congratulations, You WIN!")
    } else {
        println("I'm Sorry, But YOU LOSE!")
    }
    println("Do you wish to keep playing? \n" +
            " 1. Yes \n" +
            " 2. No")
    entradaJogador = readln().toInt()
    }
    println("Thank you for playing!")
}