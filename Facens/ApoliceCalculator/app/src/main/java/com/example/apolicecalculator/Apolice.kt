package com.example.apolicecalculator

data class Apolice(
    var numero: Int,
    var nome: String,
    var idade: Int,
    var sexo: Char,
    var valorAutomovel: Double
) {
    // Default constructor
    constructor() : this(0, "", 0, 'M', 0.0)

    // Method to calculate value
    fun calcularValor(): Double {
        return when {
            sexo == 'M' && idade <= 25 -> valorAutomovel * 0.10
            sexo == 'M' && idade > 25 -> valorAutomovel * 0.05
            sexo == 'F' -> valorAutomovel * 0.02
            else -> 0.0
        }
    }
}
