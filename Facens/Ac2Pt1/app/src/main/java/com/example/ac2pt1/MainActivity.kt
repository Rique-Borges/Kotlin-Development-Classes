package com.example.ac2pt1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.ac2pt1.FilmeList
import com.example.ac2pt1.ui.theme.Ac2Pt1Theme
import com.example.ac2pt1.viewmodels.FilmesViewModel

class MainActivity : ComponentActivity() {

    private val filmesViewModel: FilmesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ac2Pt1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FilmeList(filmes = filmesViewModel.filmes)
                }
            }
        }
    }
}
