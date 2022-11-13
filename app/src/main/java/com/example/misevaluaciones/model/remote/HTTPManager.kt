package com.example.misevaluaciones.model.remote

import com.example.misevaluaciones.model.entity.Carrera
import com.example.misevaluaciones.model.entity.LoginResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// clase (puerta) para todas las conexiones remotas
// Patrón de diseño: Fachada (significa que la clase debe ser SINGLETON)
// SINGLETON: solo debe haber 1 instancia en esta clase
class HTTPManager {

    private var evaluacionesService: EvaluacionesService //objeto de tipo Interface, el optional no es necesario gracias al init

    //el init se ejecuta cuando se construye por primera vez una instancia en la clase
    init {
        //Inicializar mi objeto retrofit que permita las conex remotas
        val retrofit = Retrofit.Builder()
            .baseUrl("https://script.google.com")
            .addConverterFactory(GsonConverterFactory.create()) //para deserializar de json a objeto kotlin
            .build()

        evaluacionesService = retrofit.create(EvaluacionesService::class.java) //instanciamos, el objeto ya está implementado/monitoreado por retrofit para la conexión remota
    }

    //patrón SINGLETON
    companion object {
        private var _instance : HTTPManager? = null //en _instance se almacena la única instancia, comienza siendo nulo

        val instance : HTTPManager
            get() { // es un getter de la variable instance (su propiedad) que se ejecuta cuando se llama a la variable instance
                if (_instance == null) {
                    _instance = HTTPManager()
                }
                return _instance!!
            }
    }

    // se llamará únicamente a esta función para hacer la conexión remota, todo lo demás está privado
    fun getCarreras() : List<Carrera>? {

        val listaCarreras = evaluacionesService.getCarreras().execute().body() //devuelve la lista de carreras en modo optional por posible error de comunicación
        return listaCarreras

    }

    fun login(cod : String, pass : String) : LoginResponse? {
        return evaluacionesService.login(cod, pass).execute().body()
    }





}