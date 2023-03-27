package com.example.almacenamiento_datos

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    var campoUsuario: EditText?=null
    var campoContraseña:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciarComponentes()
        cargarDatos()
    }

    private fun iniciarComponentes() {
        var btnCargar:Button=findViewById(R.id.btnCargar)
        btnCargar.setOnClickListener { cargarDatos() }
        campoUsuario=findViewById(R.id.idCampoUser)
        campoContraseña=findViewById(R.id.idCampoPass)
    }

    private fun cargarDatos() {
        var preferences: SharedPreferences =getSharedPreferences("credenciales", Context.MODE_PRIVATE)

        var usuario: String? =preferences.getString("Usuario","No existe la información")
        var contraseña: String? =preferences.getString("Contraseña","No existe la información")
    }
}