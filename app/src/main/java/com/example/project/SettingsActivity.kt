package com.example.project

import android.content.Intent
import com.google.firebase.auth.FirebaseAuth
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)

        val back = findViewById<ImageView>(R.id.back_button)
        back.setOnClickListener {
            finish()
        }

        val auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        val authButton: TextView = findViewById(R.id.logout) // Dynamic auth button

        if (user != null) {
            // User is logged in
            authButton.text = "Log out"
            authButton.setOnClickListener {
                auth.signOut()
                // Optionally, show a Toast or other feedback
                authButton.text = "Log in" // Update button text after logout
            }
        } else {
            // User is not logged in
            authButton.text = "Log in"
            authButton.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
