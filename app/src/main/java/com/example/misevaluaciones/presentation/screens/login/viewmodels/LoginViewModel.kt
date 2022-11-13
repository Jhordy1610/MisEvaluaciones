package com.example.misevaluaciones.presentation.screens.login.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.misevaluaciones.model.remote.HTTPManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(
    val onLoginSuccess: (String) -> Unit //se guarda el argumento (la función) como un atributo de la clase
) : ViewModel() {

    var username = mutableStateOf("")
    var password = mutableStateOf("")

    fun login() {
        viewModelScope.launch {
            val loginResponse = withContext(Dispatchers.IO) {
                HTTPManager.instance.login(
                    cod = username.value,
                    pass = password.value
                )
            }

            if (loginResponse != null) {
                if (loginResponse.msg == "") {
                    //Login correcto
                    onLoginSuccess(username.value)
                } else {
                    // Login incorrecto
                }
            }
        }
    }

}