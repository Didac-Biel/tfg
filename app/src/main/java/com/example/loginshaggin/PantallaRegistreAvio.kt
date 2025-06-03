package com.example.loginshaggin

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import android.widget.*


enum class ProviderType {
    BASIC
}

data class Connexio(
    val origen: String,
    val desti: String,
    val espaiAeri: String,
    val distancia: Int
)

class PantallaRegistreAvio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_registre_avio)

        // Referències
        val spinnerLlistaLlicencies = findViewById<Spinner>(R.id.LlistaLlicencies)
        val spinnerLlistaAvions = findViewById<Spinner>(R.id.LlistaAvions)
        val spinnerLlistaSortides = findViewById<Spinner>(R.id.LlisitaSortides)
        val spinnerLlistaArribades = findViewById<Spinner>(R.id.LlistaArribades)
        val btnCercarRuta = findViewById<Button>(R.id.btnCercarRuta)

        // Assignar valors als Spinners
        ArrayAdapter.createFromResource(this, R.array.Llicencies_array, android.R.layout.simple_spinner_item).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerLlistaLlicencies.adapter = it
        }

        ArrayAdapter.createFromResource(this, R.array.Avions_array, android.R.layout.simple_spinner_item).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerLlistaAvions.adapter = it
        }

        ArrayAdapter.createFromResource(this, R.array.Sortides_array, android.R.layout.simple_spinner_item).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerLlistaSortides.adapter = it
        }

        ArrayAdapter.createFromResource(this, R.array.Arribades_array, android.R.layout.simple_spinner_item).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerLlistaArribades.adapter = it
        }

        // Quan cliquis el botó...
        btnCercarRuta.setOnClickListener {
/*
            val llicenciaSeleccionada = spinnerLlistaLlicencies.selectedItem.toString()
            val origen = spinnerLlistaSortides.selectedItem.toString()
            val desti = spinnerLlistaArribades.selectedItem.toString()

            val espaisPerLlicencia = mapOf(
                "cqc" to listOf("Espai A"),
                "PPL" to listOf("Espai A", "Espai B"),
                "CPL" to listOf("Espai A", "Espai B", "Espai C"),
                "ATPL" to listOf("Espai A", "Espai B", "Espai C", "Espai D")
            )

            val connexions = listOf(
                Connexio("Sabadell", "Node1", "Espai A", 60),
                Connexio("Node1", "Node2", "Espai B", 80),
                Connexio("Node2", "Palma", "Espai A", 90),
                Connexio("Sabadell", "Palma", "Espai C", 70)
            )

            val espaisValids = espaisPerLlicencia[llicenciaSeleccionada] ?: listOf()
            val connexionsValides = connexions.filter { it.espaiAeri in espaisValids }

            val rutesPossibles = listOf(
                listOf("Sabadell", "Node1", "Node2", "Palma"),
                listOf("Sabadell", "Palma")
            )

            val rutesValides = rutesPossibles.filter { ruta ->
                ruta.zipWithNext().all { (origen, desti) ->
                    connexionsValides.any { it.origen == origen && it.desti == desti }
                }
            }

            val rutaMesCurta = rutesValides.minByOrNull { ruta ->
                ruta.zipWithNext().sumOf { (origen, desti) ->
                    connexionsValides.first { it.origen == origen && it.desti == desti }.distancia
                }
            }

            if (rutaMesCurta != null) {
                val intent = Intent(this, MapaActivity::class.java).apply {
                    putExtra("ruta", rutaMesCurta.joinToString(" → "))
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Cap ruta vàlida amb la llicència $llicenciaSeleccionada", Toast.LENGTH_LONG).show()
            }*/

            val intent = Intent(this, MapaActivity::class.java)
            startActivity(intent)

        }
    }
}

/*
enum class ProviderType {
    BASIC
}

class PantallaRegistreAvio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_registre_avio)

        // Referències als Spinners
        val spinnerLlistaLlicencies = findViewById<Spinner>(R.id.LlistaLlicencies)
        val spinnerLlistaAvions = findViewById<Spinner>(R.id.LlistaAvions)
        val spinnerLlistaSortides = findViewById<Spinner>(R.id.LlisitaSortides)
        val spinnerLlistaArribades = findViewById<Spinner>(R.id.LlistaArribades)

        // Assignació dels adaptadors a cada Spinner
        ArrayAdapter.createFromResource(
            this,
            R.array.Llicencies_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerLlistaLlicencies.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.Avions_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerLlistaAvions.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.Sortides_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerLlistaSortides.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.Arribades_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerLlistaArribades.adapter = adapter
        }
    }
}
*/