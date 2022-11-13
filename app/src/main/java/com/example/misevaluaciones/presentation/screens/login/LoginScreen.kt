package com.example.misevaluaciones.presentation.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.misevaluaciones.presentation.screens.login.viewmodels.LoginViewModel
import com.example.misevaluaciones.presentation.screens.login.viewmodels.LoginViewModelFactory

@Composable
fun LoginScreen(
    onLoginSuccess : (username : String) -> Unit, //se encarga de persistir/almacenar el login y verificar si es correcto
    vm : LoginViewModel = viewModel(
        factory = LoginViewModelFactory(onLoginSuccess) //gracias al factory el vm ya tiene acceso a la función onLoginSuccess(guardarCredencialesLogin)
    )
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = vm.username.value, // el .value para tener un string e ir modificándolo
            onValueChange = {
                vm.username.value = it
            }
        )

        OutlinedTextField(
            value = vm.password.value,
            onValueChange = {
                vm.password.value = it
            },
            visualTransformation = PasswordVisualTransformation()
        )

        Button(
            onClick = {
                vm.login()
            }
        )
        {
            Text(text = "Login")
        }

    }


}