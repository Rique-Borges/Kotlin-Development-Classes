package com.example.ac1

import QuestionDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ac1.ui.theme.AC1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AC1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuizApp()
                }
            }
        }
    }
}

@Composable
fun QuizApp() {
    var showQuestion1 by remember { mutableStateOf(false) }
    var showQuestion2 by remember { mutableStateOf(false) }
    var showQuestion3 by remember { mutableStateOf(false) }
    var feedbackQ1 by remember { mutableStateOf("") }
    var feedbackQ2 by remember { mutableStateOf("") }
    var feedbackQ3 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf(0) }
    var showResult by remember { mutableStateOf(false) }
    var currentQuestion by remember { mutableStateOf(0) }

    // Mostrar AlertDialog com base no estado atual
    if (showQuestion1) {
        QuestionDialog().QuestionTemplate(
            question = "Qual foi o Álbum mais vendido do Pink Floyd?",
            options = listOf("The Piper at the Gates of Dawn", "Meddle", "The Dark Side of the Moon", "Wish You Were Here", "Ummagumma"),
            correctAnswer = 2,
            onDismiss = { showQuestion1 = false },
            onAnswerSelected = { isCorrect ->
                feedbackQ1 = if (isCorrect) "Você Acertou!" else "A alternativa correta era The Dark Side of the Moon"
                if (isCorrect) result++
                showQuestion1 = false
            }
        )
    }

    if (showQuestion2) {
        QuestionDialog().QuestionTemplate(
            question = "Qual é a música mais famosa da banda Queen?",
            options = listOf("Flick of the Wrist", "Don't Stop Me Now", "Smells Like Teen Spirit", "Radio Gaga", "Bohemian Rhapsody"),
            correctAnswer = 4,
            onDismiss = { showQuestion2 = false },
            onAnswerSelected = { isCorrect ->
                feedbackQ2 = if (isCorrect) "Você Acertou!" else "A alternativa correta era Bohemian Rhapsody"
                if (isCorrect) result++
                showQuestion2 = false
            }
        )
    }

    if (showQuestion3) {
        QuestionDialog().QuestionTemplate(
            question = "Qual dessas músicas não foi feita pelos Beatles?",
            options = listOf("Blackbird", "Baby You Can Drive My Car", "Revolution 9", "Mr. Blue Sky", "Help!"),
            correctAnswer = 3,
            onDismiss = { showQuestion3 = false },
            onAnswerSelected = { isCorrect ->
                feedbackQ3 = if (isCorrect) "Você Acertou!" else "A alternativa correta era Mr. Blue Sky"
                if (isCorrect) result++
                showQuestion3 = false
            }
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
            Button(onClick = { showQuestion1 = true }, modifier = Modifier.weight(1f)) {
                Text("Questão 1")
            }
        }
        if (showResult) {
            Row {
                Text(feedbackQ1, fontStyle = FontStyle.Italic)
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
            Button(onClick = { showQuestion2 = true }, modifier = Modifier.weight(1f)) {
                Text("Questão 2")
            }

        }
        if (showResult) {
            Row {
                Text(feedbackQ2, fontStyle = FontStyle.Italic)
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
            Button(onClick = { showQuestion3 = true }, modifier = Modifier.weight(1f)) {
                Text("Questão 3")
            }

        }
        if (showResult) {
            Row {
                Text(feedbackQ3, fontStyle = FontStyle.Italic)
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { showResult = true }, modifier = Modifier.padding(horizontal = 8.dp)) {
                Text("Concluir")
            }
            Button(onClick = {
                result = 0
                feedbackQ1 = ""
                feedbackQ2 = ""
                feedbackQ3 = ""
                showResult = false
                showQuestion1 = false
                showQuestion2 = false
                showQuestion3 = false
            }) {
                Text("Limpar")
            }
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            if (showResult) {
                Text("Você acertou $result questões!", fontSize = 16.sp)
            }
        }
    }
}
