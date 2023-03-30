package com.example.almacenamiento_datos

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ActivityAlmDatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alm_datos)

        val campoMensaje=findViewById<TextView>(R.id.txtMensaje)

        var miBundle: Bundle? =this.intent.extras

        if (miBundle != null) {
            campoMensaje.text="Sus datos almacenados son:\n Usuario : ${miBundle.getString("User")}\n " +
                    "Contraseña : ${miBundle.getString("Pass")}"

        }
        val botonSalir:Button=findViewById(R.id.btnSalir)
        botonSalir.setOnClickListener{onClick()}
    }

    private fun onClick() {
       finish()
    }
}