package com.example.listsandobjects

fun main(){

    // Immutable List - Não é possível adicionar itens na lista após ela ser criada
    val shoppingList = listOf("Processador", "RAM", "Cartão GFX", "SSD")
    // Mutable List - É possível alterar os itens após ela ser criada
    val mutableShoppingList = mutableListOf("Processador", "RAM", "Cartão GFX", "SSD")

    // Adicionando itens na lista
    println(mutableShoppingList)
    mutableShoppingList.add("Gabinete")
    println(mutableShoppingList)
    mutableShoppingList.removeAt(4)
    println(mutableShoppingList)
    mutableShoppingList.add(2,"Gabinete")
    println(mutableShoppingList[2])
    println(mutableShoppingList.contains("HDD"))
    mutableShoppingList[4] = "HDD"
    println(mutableShoppingList.contains("HDD"))
    for(i in 0 until mutableShoppingList.size){
        println(mutableShoppingList[i])
        if (i == 3){
            break
        }
    }
    println(mutableShoppingList)
    println("Você gostaria de adicionar algum item? \n 1. Sim \n 2. Deletar Item \n 3. Não")
    var decisao = readln()
    while (decisao.toInt() != 3){
        if (decisao.toInt() == 1){
        println("Digite o item que você gostaria de adicionar")
        val item = readln()
        mutableShoppingList.add(item)
        println("Você gostaria de adicionar algum item? \n 1. Sim \n 2. Não")
        decisao = readln()
        }else if (decisao.toInt() == 2){
            println("Digite o numero do item á ser deletado:")
            var itemDeletado = readln()
            mutableShoppingList.removeAt(itemDeletado.toInt())
           println("Item deletado. Agora a lista é: $mutableShoppingList")
            decisao = readln()
        }
    }
    println("A lista final é: $mutableShoppingList")

}