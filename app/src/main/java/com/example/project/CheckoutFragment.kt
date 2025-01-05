package com.example.project

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth

class CheckoutFragment : Fragment(R.layout.checkout) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.checkout, container, false)

        val backButton: ImageView = view.findViewById(R.id.back_button)
        val placeButton: Button = view.findViewById(R.id.place_order_button)

        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        placeButton.setOnClickListener {
            if (checkAuthentication(requireContext())) {
                // Proceed with booking logic
                Toast.makeText(requireContext(), "Order Placed", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    private fun checkAuthentication(context: Context): Boolean {
        val user = FirebaseAuth.getInstance().currentUser
        return if (user != null) {
            true // User is authenticated
        } else {
            // Redirect to LoginActivity
            val intent = Intent(context, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            context.startActivity(intent)
            false // User is not authenticated
        }
    }
}