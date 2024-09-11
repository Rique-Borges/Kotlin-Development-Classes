package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Imager()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Imager() {
    var textNome by remember { mutableStateOf("") }
    var completeUf by remember { mutableStateOf("") }
    var expandedauto by remember { mutableStateOf(false) }
    var suggestions by remember { mutableStateOf(listOf<String>()) }
    val allSuggestions = listOf("MT", "RJ", "SP", "RS")
    var spinnerCidade by remember { mutableStateOf("") }
    var expandeddrop by remember { mutableStateOf(false) }
    val cidades = listOf("Sorocaba", "Porto Feliz", "São Paulo", "Itu", "São Roque")
    var radioButton by remember { mutableStateOf("") }

    // Update suggestions based on user input
    LaunchedEffect(completeUf) {
        suggestions = allSuggestions.filter { it.startsWith(completeUf, ignoreCase = true) }
        expandedauto = suggestions.isNotEmpty()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.borabillions),
            contentDescription = "borabillions",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = textNome,
            onValueChange = { textNome = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box {
            TextField(
                value = completeUf,
                onValueChange = { newValue ->
                    completeUf = newValue
                    expandedauto = true
                },
                label = { Text("UF") },
                modifier = Modifier.fillMaxWidth()
            )

            DropdownMenu(
                expanded = expandedauto,
                onDismissRequest = { expandedauto = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                suggestions.forEach { suggestion ->
                    DropdownMenuItem(
                        text = { Text(suggestion) },
                        onClick = {
                            completeUf = suggestion
                            expandedauto = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box {
            ExposedDropdownMenuBox(
                expanded = expandeddrop,
                onExpandedChange = { expandeddrop = !expandeddrop },
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = { expandeddrop = !expandeddrop }) {
                    Text(text = if (spinnerCidade.isEmpty()) "Cidade" else spinnerCidade)
                }
                ExposedDropdownMenu(
                    expanded = expandeddrop,
                    onDismissRequest = { expandeddrop = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    cidades.forEach { cidade ->
                        DropdownMenuItem(
                            text = { Text(cidade) },
                            onClick = {
                                spinnerCidade = cidade
                                expandeddrop = false
                            }
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            // Unused row
        }
    }
}

