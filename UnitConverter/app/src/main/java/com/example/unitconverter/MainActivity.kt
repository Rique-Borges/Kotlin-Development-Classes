package com.example.unitconverter

import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt
import kotlin.time.times

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}
@Composable
fun UnitConverter(){
    var input by remember{ mutableStateOf("") }
    var output by remember{ mutableStateOf("") }
    var inputUnit by remember{ mutableStateOf("Metros") }
    var outputUnit by remember{ mutableStateOf("Metros") }
    var inputUnitAbbr by remember{ mutableStateOf("m") }
    var outputUnitAbbr by remember{ mutableStateOf("m") }
    var iExpanded by remember{ mutableStateOf(false) }
    var oExpanded by remember{ mutableStateOf(false) }
    val conversionFactor = remember{ mutableStateOf(1.00000) }
    val oConversionFactor = remember{ mutableStateOf(1.00000) }

    fun convertUnits(){

        // ?: 0.0 - Elvis Operator(defaults null as 0.0)
        val inputValueDouble = input.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversionFactor.value * 1000.00000 / oConversionFactor.value).roundToInt() / 1000.00000
        output = result.toString()
    }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        // Todos os elementos da UI estarão sequenciados na vertical
        Text("Conversão de Unidades",
            style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = input,
            onValueChange = {
            input = it
            convertUnits()
        },
            label = { Text("Insira um Valor")})
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Box{
                // Input Button
                Button(onClick = { iExpanded = true }) {
                    Text(inputUnit)
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                    DropdownMenuItem(
                        text = { Text("Milímetros")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Milímetros"
                            inputUnitAbbr = "mm"
                            conversionFactor.value = 0.00100
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("Centímetros")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Centímetros"
                            inputUnitAbbr = "cm"
                            conversionFactor.value = 0.01000
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("Metros")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Metros"
                            inputUnitAbbr = "m"
                            conversionFactor.value = 1.00000
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("Quilômetros")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Quilômetros"
                            inputUnitAbbr = "Km"
                            conversionFactor.value = 1000.00000
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("Polegadas")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Polegadas"
                            inputUnitAbbr = "in"
                            conversionFactor.value = 0.02540
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("Pés")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Pés"
                            inputUnitAbbr = "ft"
                            conversionFactor.value = 0.30480
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("Jardas") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Jardas"
                            inputUnitAbbr = "yd"
                            conversionFactor.value = 0.91440
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("Milhas")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Milhas"
                            inputUnitAbbr = "mi"
                            conversionFactor.value = 1609.34000
                            convertUnits()
                        })

                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box{
                Button(onClick = { oExpanded = true }) {
                    Text(outputUnit)
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(
                        text = { Text("Milímetros")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Milímetros"
                            outputUnitAbbr = "mm"
                            oConversionFactor.value = 0.00100
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("Centímetros")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Centímetros"
                            outputUnitAbbr = "cm"
                            oConversionFactor.value = 0.01000
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("Metros")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Metros"
                            outputUnitAbbr = "m"
                            oConversionFactor.value = 1.00000
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("Quilômetros")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Quilômetros"
                            outputUnitAbbr = "km"
                            oConversionFactor.value = 1000.00000
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("Polegadas")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Polegadas"
                            outputUnitAbbr = "in"
                            oConversionFactor.value = 0.02540
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("Pés")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Pés"
                            outputUnitAbbr = "ft"
                            oConversionFactor.value = 0.30480
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("Jardas") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Jardas"
                            outputUnitAbbr = "yd"
                            oConversionFactor.value = 0.91440
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("Milhas")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Milhas"
                            outputUnitAbbr = "mi"
                            oConversionFactor.value = 1609.340
                            convertUnits()
                        })

                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Resultado: ${output} ${outputUnitAbbr} ",
            style = MaterialTheme.typography.headlineMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){

    UnitConverter()

}