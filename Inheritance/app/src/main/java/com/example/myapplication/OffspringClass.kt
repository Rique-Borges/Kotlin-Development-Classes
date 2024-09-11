package com.example.myapplication

class OffspringClass : SecondaryClass(), Archery, Singer {
    override fun archery() {
        super.archery()
        println("Archery skills enhanced by OffspringClass")
    }

    override fun sing() {
        super.sing()
        println("Archery skills enhanced by OffspringClass")
    }
}