package com.example.almacenamiento_datos

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var campoUsuario: EditText?=null
    var campoContraseña:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        campoUsuario= EditText(findViewById(R.id.idCampoUser))
        campoContraseña= EditText(findViewById(R.id.idCampoPass))

        val btnCargar:Button=findViewById(R.id.btnCargar)
        btnCargar.setOnClickListener{cargarDatos()}

    }

    private fun cargarDatos() {

        val preferences: SharedPreferences =getSharedPreferences("credenciales", Context.MODE_PRIVATE)

        var usuario: String? =preferences.getString("usuario","No existe la información")
        var contraseña: String? =preferences.getString("contraseña","No existe la información")

        val intent = Intent(this,ActivityAlmDatos::class.java)
       val miBundle:Bundle = Bundle()
        miBundle.putString("User", usuario)
        miBundle.putString("Pass", contraseña)
        intent.putExtras(miBundle)
        startActivity(intent)

        Toast.makeText(this,"Bienvenid@ $usuario", Toast.LENGTH_LONG).show()
    }

}

