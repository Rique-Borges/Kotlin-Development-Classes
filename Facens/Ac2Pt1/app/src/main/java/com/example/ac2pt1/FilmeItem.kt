package com.example.ac2pt1

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ac2pt1.models.Filme

@Composable
fun FilmeItem(filme: Filme) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = filme.imagemDrawable),
            contentDescription = "Poster do Filme",
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = filme.titulo,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(text = "Ano: ${filme.ano}", color = Color.Gray)
        Text(text = "Diretor: ${filme.diretor}", color = Color.Gray)

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            Toast.makeText(context, filme.sinopse, Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Ver Sinopse")
        }
    }
}

@Composable
fun FilmeList(filmes: List<Filme>) {
    LazyColumn {
        items(filmes) { filme ->
            FilmeItem(filme = filme)
        }
    }
}
