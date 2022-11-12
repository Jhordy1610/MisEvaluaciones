package com.example.misevaluaciones.model.remote

import com.example.misevaluaciones.model.entity.Carrera
import retrofit2.Call
import retrofit2.http.GET

// https://script.google.com/macros/s/AKfycbzSBsND5zTdAd0f0X-9fuFV90dlKW5rMQz7Wua24uUD58NDi3EaNdyKE6OrFwR9-IlksQ/exec
// la interface no tiene implementación ni la vamos a hacer, se le pide a retrofit que monitoree la implementación de la interface
interface EvaluacionesService {

    @GET("/macros/s/AKfycbzSBsND5zTdAd0f0X-9fuFV90dlKW5rMQz7Wua24uUD58NDi3EaNdyKE6OrFwR9-IlksQ/exec?entity=carreras")
    fun getCarreras() : Call<List<Carrera>>  //Toda llamada con retrofit devuelve un objeto Call con lo que realmente contiene esa rpta

}