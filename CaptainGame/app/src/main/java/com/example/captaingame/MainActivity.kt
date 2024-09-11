package com.example.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame()
                }
                }
        }
    }
    @Composable
    fun CaptainGame(){
        val treasuresFound = remember { mutableStateOf(0)}
        //val treasuresFound by remember {mutableStateOf(0)}
        val direction = remember { mutableStateOf("North")}
        val stormOrTreasure = remember{ mutableStateOf("") }
        val treasureHighscore = remember{ mutableStateOf(0) }

        Text("The Captain Game", fontSize = 32.sp)
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Treasures Found: ${treasuresFound.value}")
            Text("Current Direction: ${direction.value}")
            Button(onClick = {
                direction.value = "East"
                if(Random.nextBoolean()) {
                    treasuresFound.value += 1
                    stormOrTreasure.value = "Found A Treasure!"
                    if (treasuresFound.value >= treasureHighscore.value){
                        treasureHighscore.value = treasuresFound.value
                    }
                }else{
                    treasuresFound.value = 0
                    stormOrTreasure.value = "Storm Ahead! All Treasures Lost!"
                }
            }) {
                Text("Sail East")
            }
            Button(onClick = {
                direction.value = "West"
                if(Random.nextBoolean()){
                    treasuresFound.value += 1
                    stormOrTreasure.value = "Found A Treasure!"
                    if (treasuresFound.value >= treasureHighscore.value){
                        treasureHighscore.value = treasuresFound.value
                    }
                }else{
                    treasuresFound.value = 0
                    stormOrTreasure.value = "Storm Ahead! All Treasures Lost!"
                }
            }) {
                Text("Sail West")
            }
            Button(onClick = {
                direction.value = "North"
                if(Random.nextBoolean()){
                    treasuresFound.value += 1
                    stormOrTreasure.value = "Found A Treasure!"
                    if (treasuresFound.value >= treasureHighscore.value){
                        treasureHighscore.value = treasuresFound.value
                    }
                }else{
                    treasuresFound.value = 0
                    stormOrTreasure.value = "Storm Ahead! All Treasures Lost!"
                }
            }) {
                Text("Sail North")
            }
            Button(onClick = {
                direction.value = "South"
                if(Random.nextBoolean()){
                    treasuresFound.value += 1
                    stormOrTreasure.value = "Found A Treasure!"
                    if (treasuresFound.value >= treasureHighscore.value){
                        treasureHighscore.value = treasuresFound.value
                    }
                }else{
                    treasuresFound.value = 0
                    stormOrTreasure.value = "Storm Ahead! All Treasures Lost!"
                }
            }) {
                Text("Sail South")
            }
            Text(stormOrTreasure.value, fontSize = 16.sp)
            Text("Treasure Highscore: ${treasureHighscore.value}", fontSize = 16.sp)
        }

    }
}

