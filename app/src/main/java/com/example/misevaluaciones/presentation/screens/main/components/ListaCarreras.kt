package com.example.misevaluaciones.presentation.screens.main.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

import com.example.misevaluaciones.model.entity.Carrera

@Composable
fun ListaCarreras(
    carreras : List<Carrera>
) {

    LazyColumn {
        items(carreras) { carrera ->
            Text( text = carrera.nombre)
        }
    }

}