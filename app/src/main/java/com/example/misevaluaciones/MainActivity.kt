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

            //
            val countState = remember {
                mutableStateOf(0)
            }

            //
            val timer = {
                var cont = 0
                while (cont < 60) {
                    Log.i("MainActivity", cont.toString()) //pintaremos esto cada seg
                    cont += 1
                    countState.value = cont
                    Thread.sleep(1000L) //parar suspender el hilo por 1000 Milisegs
                }
            }

            //
            MainScreen(countState.value) {
                GlobalScope.launch(Dispatchers.Main) { //Esta corrutina se genera en el hilo principal, o sea, el ámbito de ejecucción es toda la App
                    //Internamente se define la tarea que se ejecutará en el hilo alterno
                    //.IO (Input-Output) es un hilo alterno para tareas de entrada y salida, ejem: Petición HTTP con un servidor web externo
                    withContext(Dispatchers.IO) {
                        timer() //se le conoce como función suspendida (ya que para la corrutina)
                    }
                    finish() //una vez que termine el dispatchers.IO, se finaliza la app
                }


                /*** USANDO CALLBACK

                val countState = remember {
                mutableStateOf(0)
                }

                val timer : (callback : () -> Unit) -> Unit = { callback -> //al acabar la función timer (en 59s), se ejecutará la función callback
                    var cont = 0
                    while (cont < 60) {
                        Log.i("MainActivity", cont.toString()) //pintaremos esto cada seg
                        cont += 1
                        countState.value = cont
                        Thread.sleep(1000L) //parar suspender el hilo por 1000 Miliseg
                    }
                    callback()
                }

                MainScreen(countState.value) {
                //se va a ejecutar al hacer click en el botón, esto gracias al StartTimer
                //por cada click, se crea un nuevo hilo
                    val hilo = Thread{
                        timer({ //todo dentro de este lambda es la función callback
                            //cuando se acabe el timer, se pintará el log y finalizará la app
                            Log.i("MainActivity", "Se terminó el primer timer")
                            //finish()
                        })
                    }
                    hilo.start()
                }
                ***/


            }
        }

    }
}


