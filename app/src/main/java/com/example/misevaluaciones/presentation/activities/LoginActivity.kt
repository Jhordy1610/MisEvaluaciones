package com.example.misevaluaciones.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.misevaluaciones.presentation.screens.login.LoginScreen

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LoginScreen(onLoginSuccess = guardarCredencialesLogin)
        }

    }

    val guardarCredencialesLogin : (String) -> Unit = { username ->
        // Guardarlo en shared preferences
        val sp = getSharedPreferences("SP_CREDENCIALES", MODE_PRIVATE) //getSharedPreferences nos da acceso a un objeto SharedPreferences de nombre "SP_CREDENCIALES"
        sp.edit().putString("USERNAME", username).commit() //necesitamos el edit() para guardar info en sp con el putString
    }

}