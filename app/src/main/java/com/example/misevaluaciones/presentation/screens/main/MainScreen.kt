package com.example.misevaluaciones.presentation.screens.main

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.misevaluaciones.model.entity.Carrera
import com.example.misevaluaciones.model.remote.HTTPManager
import com.example.misevaluaciones.presentation.screens.main.components.ListaCarreras
import com.example.misevaluaciones.presentation.screens.main.viewmodels.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun MainScreen(
    vm : MainViewModel = viewModel() //Se instancia a vm como viewModel del tipo MainViewModel si es que desde el MainActivity no se pasa el argumento
) {

    LaunchedEffect(key1 = true) {
        vm.getCarreras()
    }

    ListaCarreras(carreras = vm.listaCarreras)


//    val listaCarreras = remember {
//        mutableStateListOf<Carrera>()
//    }

    /*** Ya no es necesario, la conexión remota se hace en MainViewModel ***/
//    //LaunchedEffect: Para realizar la petición remota solo 1 vez, el contexto de la corrutina simplemente ya no es el GlobalScope, sino el Composable
//    LaunchedEffect(key1 = true) {
//        //Se realiza la conexión remota
//        var lista = withContext(Dispatchers.IO) {
//            HTTPManager.instance.getCarreras()
//        }
//
//        if (lista != null) {
//            lista.forEach() {
//                listaCarreras.add(it)
//            }
//        } else {
//            Log.e("MainScreen","Erro de comunicación con el servicio")
//        }
//    }

//    ListaCarreras(carreras = listaCarreras)

}

