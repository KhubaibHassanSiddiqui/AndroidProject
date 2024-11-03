package com.example.project
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment

class ProductFragment : Fragment(R.layout.productdetails) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.productdetails, container, false)

        val backButton: ImageView = view.findViewById(R.id.back_button)
        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val buyButton: Button = view.findViewById(R.id.buy_button)
        buyButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, CheckoutFragment())
                .addToBackStack(null)
                .commit()
        }

        val addButton: Button = view.findViewById(R.id.add_button)
        addButton.setOnClickListener {
            Toast.makeText(requireContext(), "Added to Cart", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}