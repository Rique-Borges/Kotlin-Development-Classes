package com.example.apolicecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apolicecalculator.ui.theme.ApoliceCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApoliceCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ApoliceCalculatorApp()
                }
            }
        }
    }
}

@Composable
fun ApoliceCalculatorApp() {
    var numeroInput by remember { mutableStateOf("") }
    var nomeInput by remember { mutableStateOf("") }
    var idadeInput by remember { mutableStateOf("") }
    var valorAutomovelInput by remember { mutableStateOf("") }
    val sexoOpcoes = listOf<Char>('M', 'F')
    var sexoInput by remember { mutableStateOf(sexoOpcoes.first()) }
    var result by remember { mutableStateOf("") } // State for result

    // Function to convert input to Int or Double and create Apolice
    fun createApolice(): Apolice? {
        return try {
            val numero = numeroInput.toInt()
            val nome = nomeInput
            val idade = idadeInput.toInt()
            val valorAutomovel = valorAutomovelInput.toDouble()
            Apolice(numero, nome, idade, sexoInput, valorAutomovel)
        } catch (e: Exception) {
            // Handle conversion errors here
            null
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Calculadora de Apólice",
            fontSize = 32.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        // Number Input
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
        ) {
            OutlinedTextField(
                value = numeroInput,
                onValueChange = { numeroInput = it },
                label = { Text("Número") },
                modifier = Modifier.padding(8.dp)
            )
        }
        // Name Input
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
        ) {
            OutlinedTextField(
                value = nomeInput,
                onValueChange = { nomeInput = it },
                label = { Text("Nome") },
                modifier = Modifier.padding(8.dp)
            )
        }
        // Age Input
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
        ) {
            OutlinedTextField(
                value = idadeInput,
                onValueChange = { idadeInput = it },
                label = { Text("Idade") },
                modifier = Modifier.padding(8.dp)
            )
        }
        // Value of Car Input
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
        ) {
            OutlinedTextField(
                value = valorAutomovelInput,
                onValueChange = { valorAutomovelInput = it },
                label = { Text("Valor do Automóvel") },
                modifier = Modifier.padding(8.dp)
            )
        }
        // Gender Selection
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            sexoOpcoes.forEach { sexoEscolhido ->
                Row(
                    modifier = Modifier.clickable { sexoInput = sexoEscolhido },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = sexoInput == sexoEscolhido,
                        onClick = { sexoInput = sexoEscolhido },
                        colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colorScheme.primary)
                    )
                    Text(
                        text = sexoEscolhido.toString(),
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
        }
        // Button to Create Apolice and Show Result
        Button(
            onClick = {
                val apolice = createApolice()
                result = if (apolice != null) {
                    // Format result as currency in R$
                    "Valor do Apólice: R$ ${"%.2f".format(apolice.calcularValor())}"
                } else {
                    "Failed to create Apolice. Please check your input."
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Criar Apólice")
        }
        // Display the result
        Text(
            text = result,
            fontSize = 246.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}
