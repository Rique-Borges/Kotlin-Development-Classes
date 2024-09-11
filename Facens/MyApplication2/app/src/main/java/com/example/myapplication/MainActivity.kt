package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                Calculadora()
                }
            }
        }
    }
}

@Composable
fun Calculadora(){
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var resultado by remember{ mutableStateOf(" ") }
    fun Somar(){
        resultado = ((num1.toIntOrNull() ?:0 ) + (num2.toIntOrNull() ?: 0)).toString()
    }
    fun Subtrair(){
        resultado = ((num1.toIntOrNull() ?:0 ) - (num2.toIntOrNull() ?: 0)).toString()
    }
    fun Limpar(){
        num1 = ""
        num2 = ""
        resultado = "0"
    }
    Column (modifier = Modifier
        .fillMaxSize()){
        Spacer(modifier = Modifier.height(32.dp))
        Row (modifier = Modifier
            .fillMaxWidth()){
            OutlinedTextField(
                value = num1,
                onValueChange = { num1 = it },
                label = { Text(text = "Número 1")},
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row (modifier = Modifier
            .fillMaxWidth()){
            OutlinedTextField(
                value = num2,
                onValueChange = { num2 = it },
                label = { Text(text = "Número 1")},
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row (modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center){
            Column {
                Button(onClick = { Somar() }) {
                    Text(text = "Somar")
                }
            }
            Column {
                Button(onClick = { Subtrair() }) {
                    Text(text = "Subtrair")
                }
            }
            Column {
                Button(onClick = { Limpar() }) {
                    Text(text = "Limpar")
                }
            }
        }
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center){
            Text(text = "Resultado: $resultado", fontSize = 24.sp)
        }
    }
}