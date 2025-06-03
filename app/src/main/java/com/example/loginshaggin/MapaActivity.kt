package com.example.loginshaggin

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolylineOptions

class MapaActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_mapa) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // 1. Definim les coordenades conegudes
        val punts = mapOf(
            "Sabadell" to LatLng(41.5167, 2.1000),
            "Node1" to LatLng(41.6, 2.3),
            "Node2" to LatLng(41.8, 2.7),
            "Palma" to LatLng(39.5696, 2.6502)
        )

        // 2. Rebem la ruta en format String: "Sabadell → Node1 → Node2 → Palma"
        val rutaText = intent.getStringExtra("ruta")
        if (rutaText == null) {
            return // No hi ha res a dibuixar
        }

        val nomsPunts = rutaText.split(" → ")

        // 3. Convertim noms en coordenades
        val polyline = PolylineOptions()
            .width(10f)
            .color(Color.BLUE)

        for (nom in nomsPunts) {
            punts[nom]?.let {
                polyline.add(it)
            }
        }

        // 4. Dibuixem la línia al mapa
        map.addPolyline(polyline)

        // 5. Centrem la càmera al primer punt de la ruta
        punts[nomsPunts.first()]?.let {
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(it, 7f))
        }
    }
}






/*package com.example.loginshaggin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

class MapaActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)

        createFragment()



       /* val rutaText = intent.getStringExtra("ruta")
        val textView = findViewById<TextView>(R.id.txtRuta)
        textView.text = "Ruta escollida:\n$rutaText"*/

    }

    private fun createFragment() {
        val mapFragment : SupportMapFragment = supportFragmentManager.findFragmentById(R.id.fragment_mapa) as SupportMapFragment

        mapFragment.getMapAsync(this)

        }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
    }
}*/

