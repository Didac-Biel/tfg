package com.example.loginshaggin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MapaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)

        val rutaText = intent.getStringExtra("ruta")
        val textView = findViewById<TextView>(R.id.txtRuta)
        textView.text = "Ruta escollida:\n$rutaText"
    }
}
