package com.example.misevaluaciones.presentation.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(
    count: Int, //count es el countState.value, o sea irá cambiando, empieza en 0
    startTimer: () -> Unit //esto siempre al final para el lambda del MainScreen(){}
) {
    //El Box para posicionar el componente en zonas especiales
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = { startTimer() }, //por cada click, se crea un nuevo hilo
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Text(text = "Click")
        }
        Text(
            text = count.toString(), //al hacer click este "count" ya está interconectado con el "countState.value" hasta la finalización del hilo
            modifier = Modifier.align(Alignment.Center)
        )
    }

}