package com.example.misevaluaciones.presentation.screens.main.viewmodels

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.misevaluaciones.model.entity.Carrera
import com.example.misevaluaciones.model.remote.HTTPManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// Se encarga de conversar con el model para realizar la llamada remota
// Acá se almacena la lista de carreras
class MainViewModel : ViewModel() {

    val listaCarreras = mutableStateListOf<Carrera>()

    fun getCarreras() {

        //El contexto de vida del viewModelScope persiste más tiempo que el del LaunchedEffect, es decir, de un Screen "@composable MainScreen"
        viewModelScope.launch {
            //Se realiza la conexión remota
            var lista = withContext(Dispatchers.IO) {
                HTTPManager.instance.getCarreras()
            }

            if (lista != null) {
                lista.forEach() {
                    listaCarreras.add(it)
                }
            } else {
                Log.e("MainScreen", "Error de comunicación con el servicio")
            }
        }

    }

}