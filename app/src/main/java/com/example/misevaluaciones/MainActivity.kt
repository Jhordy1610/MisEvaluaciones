package com.example.misevaluaciones

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.misevaluaciones.model.remote.HTTPManager
import com.example.misevaluaciones.presentation.screens.main.MainScreen
import com.example.misevaluaciones.ui.theme.MisEvaluacionesTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }

        /*** Ya no es necesario, la conexión remota se hace en MainViewModel ***/
//        GlobalScope.launch {
//            //Se realiza la conexión remota
//            val httpManager = HTTPManager.instance
//
//            val listaCarreras = withContext(Dispatchers.IO) {
//                httpManager.getCarreras()
//            }
//
//            if (listaCarreras != null) {
//                Log.i("MainActivity", listaCarreras.size.toString())
//            } else {
//                Log.e("MainActivity", "Error en el servicio")
//            }
//        }

    }

}



