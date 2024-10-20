package com.example.project
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.homepage) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.homepage, container, false)
        setUpClickListener(view.findViewById(R.id.productimg))
        setUpClickListener(view.findViewById(R.id.productimg2))
        setUpClickListener(view.findViewById(R.id.productimg3))
        setUpClickListener(view.findViewById(R.id.productimg4))
        return view
    }

    private fun setUpClickListener(view: View) {
        view.setOnClickListener {
            val intent = Intent(requireActivity(), ProductActivity::class.java)
            startActivity(intent)
        }
    }
}
