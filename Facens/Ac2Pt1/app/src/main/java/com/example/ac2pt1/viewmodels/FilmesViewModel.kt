package com.example.ac2pt1.viewmodels

import androidx.lifecycle.ViewModel
import com.example.ac2pt1.models.Filme
import com.example.ac2pt1.R

class FilmesViewModel : ViewModel() {
    val filmes = listOf(
        Filme(
            titulo = "One Flew Over The Cuckoo's Nest",
            ano = 1975,
            sinopse = "Randall McMurphy, um criminoso com passado rebelde, é transferido para um hospital psiquiátrico, onde desafia a enfermeira-chefe e incentiva os pacientes a buscar sua liberdade.",
            diretor = "Milos Forman",
            imagemDrawable = R.drawable.poster0
        ),
        Filme(
            titulo = "Good Will Hunting",
            ano = 1997,
            sinopse = "Will Hunting, um jovem prodígio da matemática com uma infância difícil, é descoberto pelo professor Gerald Lambeau e inicia uma jornada de autoconhecimento e superação com a ajuda do psicólogo Sean Maguire.",
            diretor = "Gus Van Sant",
            imagemDrawable = R.drawable.poster1
        ),
        Filme(
            titulo = "The Substance",
            ano = 2024,
            sinopse = "Uma sátira de horror corporal sobre uma celebridade decadente que usa uma droga ilegal para se transformar em uma versão mais jovem de si mesma, desencadeando efeitos colaterais inesperados. O filme explora temas como misoginia, preconceito contra a idade e a indústria de Hollywood",
            diretor = "Gus Van Sant",
            imagemDrawable = R.drawable.poster2
        )
    )
}