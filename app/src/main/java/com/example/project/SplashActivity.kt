package com.example.project

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the splash screen layout
        setContentView(R.layout.activity_splash)

        // Create a Handler to delay the transition to MainActivity
        Handler().postDelayed({
            // Start the main activity after the splash screen delay
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()  // Finish the SplashActivity so the user can't go back to it
        }, 3000)  // Show splash for 3 seconds (3000ms)
    }
}
