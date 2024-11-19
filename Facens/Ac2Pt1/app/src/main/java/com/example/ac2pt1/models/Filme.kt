package com.example.ac2pt1.models

import androidx.annotation.DrawableRes

data class Filme(
    val titulo: String,
    val ano: Int,
    val sinopse: String,
    val diretor: String,
    @DrawableRes val imagemDrawable: Int
)
