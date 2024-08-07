package com.example.programacontadebanco

class BankAccount(var accountHolder: String, var balance: Double) {
    private val transactionHistory = mutableListOf<String>()

    fun deposit(amount: Double){
    balance += amount
    transactionHistory.add("$accountHolder depositou R$$amount")
    }

    fun withdrawal(amount: Double){
        if (amount <= balance){
            balance -= amount
            transactionHistory.add("$accountHolder sacou R$$amount")
        }else{
            println("Você não possui dinheiro suficiente para essa transação")
        }
    }
    fun displayTransactionHistory(){
        println("Extrato de $accountHolder")
        for(i in 0 until transactionHistory.size){
            println(transactionHistory[i])
        }
    }
    fun accBalance(){
        println("$accountHolder's balance is R$$balance")
    }
}