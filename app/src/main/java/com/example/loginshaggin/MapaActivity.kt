package com.example.loginshaggin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.CameraUpdateFactory


class MapaActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)
        createFragment()
        //val rutaText = intent.getStringExtra("ruta")
        //val textView = findViewById<TextView>(R.id.txtRuta)
        //textView.text = "Ruta escollida:\n$rutaText"
    }
    private fun createFragment() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.fragment_mapa) as SupportMapFragment
        mapFragment.getMapAsync (this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Defineix un punt (per exemple, Sabadell)
        val sabadell = LatLng(41.5421, 2.1053)

        // Mou la càmera a Sabadell amb zoom 10
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sabadell, 10f))
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

