package com.example.project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.productdetails)

        val backButton: ImageView = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            finish()
        }

        val buyButton: Button = findViewById(R.id.buy_button)
        buyButton.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }

        val addButton: Button = findViewById(R.id.add_button)
        addButton.setOnClickListener {
            Toast.makeText(this, "Added to Cart", Toast.LENGTH_SHORT).show()
        }
    }
}
