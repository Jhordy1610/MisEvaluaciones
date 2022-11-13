package com.example.misevaluaciones.model.remote

import com.example.misevaluaciones.model.entity.Carrera
import com.example.misevaluaciones.model.entity.LoginResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// https://script.google.com/macros/s/AKfycbzSBsND5zTdAd0f0X-9fuFV90dlKW5rMQz7Wua24uUD58NDi3EaNdyKE6OrFwR9-IlksQ/exec
// la interface no tiene implementación ni la vamos a hacer, se le pide a retrofit que monitoree la implementación de la interface
interface EvaluacionesService {

    @GET("/macros/s/AKfycbzSBsND5zTdAd0f0X-9fuFV90dlKW5rMQz7Wua24uUD58NDi3EaNdyKE6OrFwR9-IlksQ/exec?entity=carreras")
    fun getCarreras() : Call<List<Carrera>>  //Toda llamada con retrofit devuelve un objeto Call con lo que realmente contiene esa rpta

    //https://script.google.com/macros/s/AKfycbzSBsND5zTdAd0f0X-9fuFV90dlKW5rMQz7Wua24uUD58NDi3EaNdyKE6OrFwR9-IlksQ/exec?entity=login&codigo=20201111&password=123
    @GET("/macros/s/AKfycbzSBsND5zTdAd0f0X-9fuFV90dlKW5rMQz7Wua24uUD58NDi3EaNdyKE6OrFwR9-IlksQ/exec?entity=login")
    fun login(
        @Query("codigo") cod : String, //lo que está entre () es el query parameter tal cual va en la url
        @Query("password") pass: String
    ) : Call<LoginResponse>

}

