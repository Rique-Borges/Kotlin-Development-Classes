package com.example.leetcodelmao

fun lengthOfLongestSubstring(s: String): Int {
    val slength = s.length
    var i = 0
    val listofchar = mutableListOf<Char>()
    while (i != slength){
        val cha:Char = s.get(i)
        i++
        if (cha == listofchar[i]){
            listofchar.add(i, cha)

        }else{ println(listofchar.size)
            }
        }
        return listofchar.size
    }
fun main(){
    println(lengthOfLongestSubstring("astjkadf"))

}