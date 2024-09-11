package com.example.myapplication

// Derived class of BaseClass
// Inherits from BaseClass
open class SecondaryClass: BaseClass() {
    override fun role() {
        //super.role()
        println("Knight of the house of BaseClass")
    }
}