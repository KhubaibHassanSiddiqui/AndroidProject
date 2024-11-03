package com.example.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class HomeFragment : Fragment(R.layout.homepage) {
    private lateinit var viewPager: ViewPager2
    private lateinit var imageSliderAdapter: ImageSliderAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.homepage, container, false)
        setUpClickListener(view.findViewById(R.id.productimg))
        setUpClickListener(view.findViewById(R.id.productimg2))
        setUpClickListener(view.findViewById(R.id.productimg3))
        setUpClickListener(view.findViewById(R.id.productimg4))

        viewPager = view.findViewById(R.id.viewPager)

        val imageList = listOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4
        )

        imageSliderAdapter = ImageSliderAdapter(imageList)
        viewPager.adapter = imageSliderAdapter

        val voucherButton=view.findViewById<TextView>(R.id.voucherLink)
        voucherButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, VoucherFragment())
                .addToBackStack(null)
                .commit()
        }

        val vouchers : View =view.findViewById(R.id.vouchers)
        vouchers.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, VoucherFragment())
                .addToBackStack(null)
                .commit()
        }

        val voucherimg: View = view.findViewById(R.id.voucherImage)
        voucherimg.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, ActivitiesFragment())
                .addToBackStack(null)
                .commit()
        }
        return view
    }

    private fun setUpClickListener(view: View) {
        view.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, ProductFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
