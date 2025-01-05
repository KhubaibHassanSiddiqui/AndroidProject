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

class VoucherFragment : Fragment(R.layout.vouchers) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.vouchers, container, false)

        val backButton: ImageView = view.findViewById(R.id.back_button)
        val button1:Button=view.findViewById(R.id.collectbutton1)
        val button2:Button=view.findViewById(R.id.collectbutton2)
        val button3:Button=view.findViewById(R.id.collectbutton3)
        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        button1.setOnClickListener {
            if (checkAuthentication(requireContext())) {
                Toast.makeText(requireContext(), "Voucher Collected", Toast.LENGTH_SHORT).show()
            }
        }
        button2.setOnClickListener {
            if (checkAuthentication(requireContext())) {
                Toast.makeText(requireContext(), "Voucher Collected", Toast.LENGTH_SHORT).show()
            }
        }
        button3.setOnClickListener {
            if (checkAuthentication(requireContext())) {
                Toast.makeText(requireContext(), "Voucher Collected", Toast.LENGTH_SHORT).show()
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