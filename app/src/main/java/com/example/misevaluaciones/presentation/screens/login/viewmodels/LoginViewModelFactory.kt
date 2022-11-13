package com.example.misevaluaciones.presentation.screens.login.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// Se hereda de la interface .Factory, por eso no se colocan los paréntesis
// Las interfaces nos piden implementar sus métodos
class LoginViewModelFactory(
    private val onLoginSuccess: (String) -> Unit //es private val para que se pueda utilizar en el return
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //return super.create(modelClass)
        return LoginViewModel(onLoginSuccess) as T
    }


}