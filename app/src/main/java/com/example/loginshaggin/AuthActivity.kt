package com.example.loginshaggin

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class AuthActivity : AppCompatActivity() {

    // Firebase
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        title = "Autenticació"

        // Inicialitzar Firebase
        auth = FirebaseAuth.getInstance()

        setup()
    }

    private fun setup() {
        val registerButton = findViewById<Button>(R.id.RegistreButton)
        val loginButton = findViewById<Button>(R.id.LogInButton)
        val emailEditText = findViewById<EditText>(R.id.EmailEditText)
        val passwordEditText = findViewById<EditText>(R.id.PasswordText)

        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showPantallaRegistreAvio(it.result?.user?.email ?: "", ProviderType.BASIC)
                    } else {
                        showAlert()
                    }
                }
            }
        }

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showPantallaRegistreAvio(it.result?.user?.email ?: "", ProviderType.BASIC)
                    } else {
                        showAlert()
                    }
                }
            }
        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("S'ha produït un error en l'autenticació")
        builder.setPositiveButton("Acceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showPantallaRegistreAvio(email: String, provider: ProviderType) {
        val pantallaRegistreAvioIntent = Intent(this, PantallaRegistreAvio::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(pantallaRegistreAvioIntent)
    }
}
