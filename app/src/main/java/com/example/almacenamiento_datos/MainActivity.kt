package com.example.almacenamiento_datos

import android.content.Context
import android.content.Intent
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

        val btnCargar:Button=findViewById(R.id.btnCargar)
        btnCargar.setOnClickListener{cargarDatos()}

        iniciarComponentes()
        cargarDatos()
    }

    private fun iniciarComponentes() {


        campoUsuario=findViewById(R.id.idCampoUser)
        campoContraseña=findViewById(R.id.idCampoPass)
    }

    private fun cargarDatos() {

        val campoUsuario: EditText = findViewById(R.id.idCampoUser)
        val campoContraseña: EditText = findViewById(R.id.idCampoPass)

        val usuario:String = campoUsuario.text.toString()
        val contraseña:String = campoContraseña.text.toString()

        val preferences: SharedPreferences =getSharedPreferences("credenciales", Context.MODE_PRIVATE)

        var usuario1: String? =preferences.getString("Usuario","No existe la información")
        var contraseña1: String? =preferences.getString("Contraseña","No existe la información")

        val intent = Intent(this, ActivityMensage::class.java)
        val content: Bundle = Bundle()
        content.putString("User", usuario)
        content.putString("Pass", contraseña)
    }



    }
}