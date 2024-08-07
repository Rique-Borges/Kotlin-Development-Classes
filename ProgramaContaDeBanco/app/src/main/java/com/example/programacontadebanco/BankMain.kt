package com.example.programacontadebanco

fun main(){
    val rikeBankAccount = BankAccount("Henrique Ribeiro Borges", 138.46)
    println(rikeBankAccount.accountHolder)
    rikeBankAccount.withdrawal(50.00)
    rikeBankAccount.deposit(43.70)
    rikeBankAccount.deposit(540.67)
    rikeBankAccount.withdrawal(350.00)
    rikeBankAccount.displayTransactionHistory()
    rikeBankAccount.accBalance()
    val alanBankAccount = BankAccount("Alan Marie Maia", 0.0)
    alanBankAccount.deposit(100.0)
    alanBankAccount.withdrawal(10.0)
    alanBankAccount.deposit(300.0)
    alanBankAccount.displayTransactionHistory()
    alanBankAccount.accBalance()

}